package com.drama.taxi.service;

import com.drama.taxi.domain.Booking;
import com.drama.taxi.domain.User;
import com.drama.taxi.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

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


}
