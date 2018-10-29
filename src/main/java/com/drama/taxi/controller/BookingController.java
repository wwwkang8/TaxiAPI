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

    /*배차 신청 페이지로 이동하는 메서드*/
    @GetMapping("/form")
    public String bookingForm(){
        return "booking/bookingForm";
    }

    /*배차 등록하는 메서드*/
    @PostMapping("")
    public String bookingTaxi(@RequestParam(name="destination") String dest, HttpSession session){
        if(!HttpSessionUtils.isLoginUser(session)){ //Session이 없다면 메인 페이지로 이동
            return "/users/noSession";
        }
        bookingService.bookingTaxi(dest, session);
        return "/booking/bookingSuccess";
    }

    /*배차 성공시 보여주는 페이지*/
    @GetMapping("/bookingSuccess")
    public String bookingSuccess(){
        return "/booking/bookingSuccess";
    }

    /*배차 상태를 업데이트 하는 메서드*/
    @PostMapping("/update")
    @ResponseBody
    public String updateBooking(String bookingNo, String driverId){

        String result=bookingService.updateBooking(bookingNo, driverId);

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
