package com.drama.taxi.controller;

import com.drama.taxi.domain.User;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {
    public static final String USER_SESSION_KEY = "sessionedUser";

    /*로그인을 확인하는 메서드*/
    public static boolean isLoginUser(HttpSession session) {
        Object sessionedUser = session.getAttribute(USER_SESSION_KEY); //USER_SESSION_KEY에 해당하는 세션 객체를 가져온다.
        if (sessionedUser == null) {//만약 세션 객체가 null이라면 로그인을 하지 않은 상태
            return false;
        }
        return true;
    }

    /*세션 객체를 불러오는 메서드*/
    public static User getUserFromSession(HttpSession session) {
        if (!isLoginUser(session)) {
            return null;
        }
        return (User) session.getAttribute(USER_SESSION_KEY);
    }
}
