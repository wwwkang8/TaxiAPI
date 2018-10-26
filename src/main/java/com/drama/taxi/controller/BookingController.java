package com.drama.taxi.controller;

import com.drama.taxi.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/form")
    public String bookingForm(){
        return "booking/bookingForm";
    }

}
