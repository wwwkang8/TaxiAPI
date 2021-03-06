package com.drama.taxi.service;

import com.drama.taxi.controller.HttpSessionUtils;
import com.drama.taxi.domain.Booking;
import com.drama.taxi.domain.User;
import com.drama.taxi.repository.BookingRepository;
import com.drama.taxi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;

    /*모든 배차 리스트를 최신순으로 가져오는 메서드*/
    public List<Booking> getBookingList(){
        return bookingRepository.findAllByOrderByCreateDateDesc();
    }

    /*배차 신청을 등록하는 메서드*/
    public void bookingTaxi(String dest, HttpSession session){
        User sessionedUser = HttpSessionUtils.getUserFromSession(session);

        /*입력 받은 배차 정보를 이용하여 Booking 객체를 생성*/
        Booking booking=new Booking(dest, sessionedUser.getUserEmail(), "배차대기", null, LocalDateTime.now(), null, sessionedUser);
        bookingRepository.save(booking);//배차 정보 저장.
    }

    /*특정 승객의 배차 정보를 가져오는 메서드*/
    public List<Booking> findPassengerBookingList(Long id){
        return bookingRepository.findPassengerBookingList(id);
    }

    /*택시기사가 배차를 수락했을 때 예약을 업데이트 하는 트랜잭션*/
    @Transactional
    public String updateBooking(String bookingNumber, String driverNumber){
        Long bookingNum=Long.parseLong(bookingNumber); // String 타입의 예약번호를 Long 형으로 변환
        Long driverNum=Long.parseLong(driverNumber); // String 타입의 택시기사번호를 Long 형으로 변환

        String result=""; //Ajax에 반환할 성공여부
        User driver=userRepository.findUserById(driverNum); //택시 기사의 정보를 가져온다.
        Booking booking=bookingRepository.findBookingById(bookingNum);//업데이트할 예약정보를 불러온다.

        if(driver.getIsAvailable()==1&&booking.getDriver()==null){//택시기사가 배차 수락이 가능한 경우

            booking.setAssignedDate(LocalDateTime.now()); //배차가 완료된 시각을 입력
            booking.setDriver(driver.getUserEmail()); //운전할 택시기사의 이메일을 입력
            booking.setStatus("배차완료");
            driver.setIsAvailable(0);//배차가 되면 더 이상 배차가 되지 않도록 0으로 변경.
            bookingRepository.saveAndFlush(booking); //변경된 예약정보를 DB와 동기화.
            userRepository.saveAndFlush(driver);
            result="success";
        }else{//택시기사가 이미 배차가 되어있어서 배차 수락이 불가능한 경우
            result="fail";
        }

        return result;
    }


}
