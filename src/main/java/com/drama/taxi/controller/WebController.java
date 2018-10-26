package com.drama.taxi.controller;

import com.drama.taxi.domain.Booking;
import com.drama.taxi.domain.User;
import com.drama.taxi.service.BookingService;
import com.drama.taxi.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
public class WebController {

    @Autowired
    BookingService bookingService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/passenger")
    public ModelAndView passengerMain(HttpSession session){
        User sessionedUser=(User)HttpSessionUtils.getUserFromSession(session);
        System.out.println("해당 승객의 배차 목록  : "+bookingService.getPassengerBookingList(sessionedUser));
        ModelAndView mv=new ModelAndView("passenger_index", "booking", bookingService.getPassengerBookingList(sessionedUser));
        return mv;
    }


    @GetMapping("/driver")
    public ModelAndView driverMain(HttpSession session){
        User sessionedUser=(User)HttpSessionUtils.getUserFromSession(session);
        ModelAndView mv=new ModelAndView("driver_index","booking",(List<Booking>)bookingService.getBookingList());

        return mv;

    }
}