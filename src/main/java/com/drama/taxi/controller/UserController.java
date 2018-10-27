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
    public String login(String userEmail, String password, HttpSession session, Model model){
        User user=userService.findByUserEmail(userEmail);

        if (user == null) {
            System.out.println("Login fail");
            return "redirect:/users/loginFail";
        }

        if (!user.matchPassword(password)) {
            System.out.println("Login fail");
            return "redirect:/users/loginForm";
        }
        System.out.println("Login Success");
        session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, user);
        User sessionedUser=(User)HttpSessionUtils.getUserFromSession(session);
        if(sessionedUser.getUserType().equals("passenger")){
            return "redirect:/passenger";
        }else{
            return "redirect:/driver";
        }
    }

    @GetMapping("/loginFail")
    public String loginFail(){
        return "/user/loginFail";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
        return "redirect:/";
    }

}
