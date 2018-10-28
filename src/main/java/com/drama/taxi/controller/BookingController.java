package com.drama.taxi.controller;

import com.drama.taxi.domain.Booking;
import com.drama.taxi.domain.User;
import com.drama.taxi.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
            return "/users/noSession";
        }
        bookingService.bookingTaxi(dest, session);
        return "/booking/bookingSuccess";
    }

    @GetMapping("/bookingSuccess")
    public String bookingSuccess(){
        return "/booking/bookingSuccess";
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateBooking(String bookingNo, String driverId){
        Long bookingNum=Long.parseLong(bookingNo);
        Long driverNum=Long.parseLong(driverId);

        String result=bookingService.updateBooking(bookingNum, driverNum);

        return result;
    }

    /*택시기사에게 배차가 완료되었을 때*/
    @GetMapping("/acceptSuccess")
    public String acceptSuccess(){
        return "/booking/acceptSuccess";
    }

    /*택시기사에게 배차가 실패했을 때*/
    @GetMapping("/acceptFail")
    public String acceptFail(){
        return "/booking/acceptFail";
    }


}
