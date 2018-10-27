package com.drama.taxi;

import com.drama.taxi.repository.BookingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaxiApplicationTests {


    @Autowired
    BookingRepository bookingRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void bookingList(){
        Long id=Long.parseLong("1");
        System.out.println(bookingRepository.findPassengerBookingList(id));
    }



}
