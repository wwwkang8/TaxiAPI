package com.drama.taxi.controller;

import com.drama.taxi.domain.User;
import com.drama.taxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BookingController bookingController;

    @GetMapping("/regForm")
    public String registerForm(){
        return "/user/regForm";
    }

    @PostMapping("/register")
    public String userRegister(User user){
        userService.userRegister(user);
        return "/user/registerSuccess";
    }

    @GetMapping("/registerSuccess")
    public String registerSuccess(){
        return "redirect:/";
    }

    @PostMapping("/checkEmail")
    @ResponseBody
    public String checkEmail(@RequestParam(name="userEmail") String userEmail){
        int count = userService.checkEmail(userEmail);
        return (count == 0) ? "ok" : "fail";
    }

    @PostMapping("/login")
    public String login(String userEmail, String password, HttpSession session){

        String result=userService.login(userEmail, password, session);

        return result;
    }

    /*로그인 실패시 보여주는 페이지*/
    @GetMapping("/loginFail")
    public String loginFail(){
        return "/user/loginFail";
    }

    /*세션이 없을 때 메인 페이지로 이동 시켜주는 메서드*/
    @GetMapping("/noSession")
    public String noSession(){
        return "/user/noSession";
    }

    /*로그 아웃*/
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
        return "redirect:/";
    }

}
