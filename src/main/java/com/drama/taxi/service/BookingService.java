package com.drama.taxi.service;

import com.drama.taxi.domain.Booking;
import com.drama.taxi.domain.User;
import com.drama.taxi.repository.BookingRepository;
import com.drama.taxi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Booking> getBookingList(){
        return bookingRepository.findAllByOrderByCreateDateDesc();
    }

    public void bookingTaxi(Booking booking){
        bookingRepository.save(booking);
    }

    public List<Booking> findPassengerBookingList(Long id){
        return bookingRepository.findPassengerBookingList(id);
    }

    /*택시기사가 배차를 수락했을 때 예약을 업데이트 하는 트랜잭션*/
    @Transactional
    public String updateBooking(Long bookingNum, Long driverNum){

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
