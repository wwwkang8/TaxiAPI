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

    public Booking getPassengerBookingList(User user){
        Long userId=user.getId();
        return bookingRepository.findBookingById(userId);
    }

    /*택시기사가 배차를 수락했을 때 예약을 업데이트 하는 트랜잭션*/
    @Transactional
    public String updateBooking(Long bookingNum, Long driverNum){
        User driver=userRepository.findUserById(driverNum); //택시 기사의 정보를 가져온다.
        Booking booking=bookingRepository.findBookingById(bookingNum); //업데이트할 예약정보를 불러온다.
        booking.setAssignedDate(LocalDateTime.now()); //배차가 완료된 시각을 입력
        booking.setDriver(driver.getUserEmail()); //운전할 택시기사의 이메일을 입력
        booking.setStatus("배차완료");
        bookingRepository.saveAndFlush(booking); //변경된 예약정보를 DB와 동기화.

        return "success";
    }


}
