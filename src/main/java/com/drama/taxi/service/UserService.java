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

    /*이메일 중복 여부 체크*/
    public int checkEmail(String userEmail){
        int count=0; // 이메일 중복여부를 체크하는 변수

        User user=userRepository.findByUserEmail(userEmail); //DB에 해당 이메일의 User 객체를 불러온다.
        if(user ==null) //User 객체가 null이라면 중복되지 않은 이메일
            count=0;
        else
            count=1;

        return count;
    }

    /*회원가입*/
    public void userRegister(User user){
        /*회원가입 폼으로부터 받은 User 정보를 DB에 저장한다.*/
        userRepository.save(user);
    }

    /*이메일로 유저 객체를 찾는 함수*/
    public User findByUserEmail(String userEmail){
        return userRepository.findByUserEmail(userEmail);
    }

    /*로그인 기능*/
    public String login(String userEmail, String password, HttpSession session){
        User user=this.findByUserEmail(userEmail); //이메일로 User객체를 찾는다. 같은 클래스 내부여서 this 키워드 사용하여 메서드 호출.
        String result=""; //로그인 결과를 담는 변수

        if (user == null) { //이메일에 해당하는 User 객체가 없을 경우 loginFail
            result= "redirect:/users/loginFail";
        }

        if (!user.matchPassword(password)) { //User 객체의 비밀번호와 입력 받은 비밀번호가 일치하지 않으면 loginFail
            result= "redirect:/users/loginFail";
        }

        session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, user); //세션에 User 객체 저장.
        User sessionedUser=(User)HttpSessionUtils.getUserFromSession(session);

        /*User 타입에 따라 분기처리*/
        if(sessionedUser.getUserType().equals("passenger")){//User 타입이 승객인 경우 승객 페이지로 이동
            result= "redirect:/passenger";
        }else{//User 타입이 택시기사인 경우 택시기사 페이지로 이동.
            result= "redirect:/driver";
        }

        return result;
    }


}
