package com.drama.taxi.service;

import com.drama.taxi.controller.HttpSessionUtils;
import com.drama.taxi.domain.Booking;
import com.drama.taxi.domain.User;
import com.drama.taxi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public int checkEmail(String userEmail){
        int count=0;
        User user=userRepository.findByUserEmail(userEmail);
        if(user ==null)
            count=0;
        else
            count=1;

        System.out.println("User service count : "+count);

        return count;
    }

    public void userRegister(User user){
        userRepository.save(user);
    }

    public User findByUserEmail(String userEmail){
        return userRepository.findByUserEmail(userEmail);
    }

    public String login(String userEmail, String password, HttpSession session){
        User user=this.findByUserEmail(userEmail);
        String result="";

        if (user == null) {
            System.out.println("Login fail");
            result= "redirect:/users/loginFail";
        }

        if (!user.matchPassword(password)) {
            System.out.println("Login fail");
            result= "redirect:/users/loginForm";
        }
        System.out.println("Login Success");
        session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, user);
        User sessionedUser=(User)HttpSessionUtils.getUserFromSession(session);
        if(sessionedUser.getUserType().equals("passenger")){
            result= "redirect:/passenger";
        }else{
            result= "redirect:/driver";
        }

        return result;
    }


}
