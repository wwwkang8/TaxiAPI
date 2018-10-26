package com.drama.taxi.controller;

import com.drama.taxi.domain.Booking;
import com.drama.taxi.domain.User;
import com.drama.taxi.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/form")
    public String bookingForm(){
        return "booking/bookingForm";
    }


    @PostMapping("/")
    public String bookingTaxi(@RequestParam(name="destination") String dest, HttpSession session){
        if(!HttpSessionUtils.isLoginUser(session)){
            return "/passenger";
        }

        User sessionedUser = HttpSessionUtils.getUserFromSession(session);
        Booking booking=new Booking(dest, sessionedUser.getUserEmail(), "waiting", null, LocalDateTime.now(), null, sessionedUser);
        bookingService.bookingTaxi(booking);

        return "/booking/bookingSuccess";
    }

    @GetMapping("/bookingSuccess")
    public String bookingSuccess(){
        return "/booking/bookingSuccess";
    }

}
