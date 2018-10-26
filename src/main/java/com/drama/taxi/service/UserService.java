package com.drama.taxi.service;

import com.drama.taxi.domain.Booking;
import com.drama.taxi.domain.User;
import com.drama.taxi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
