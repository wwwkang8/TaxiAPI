package com.drama.taxi.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("passenger")
    public String passengerMain(){return "passenger_index";}

    @GetMapping("driver")
    public String driverMain(){return "driver_index";}
}