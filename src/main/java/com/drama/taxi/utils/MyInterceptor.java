package com.drama.taxi.utils;

import com.drama.taxi.controller.HttpSessionUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("***********핸들러 인터셉터 실행************"+request.getRequestURI());
        HttpSession session=request.getSession(false); //세션을 불러온다. false 옵션은 세션이 없으면 null을 반환하는 옵션.
        if(session != null && session.getAttribute(HttpSessionUtils.USER_SESSION_KEY)!=null){
            return true;
        }else{
            /*세션이 없는 경우 이동하는 URL*/
            response.sendRedirect("/users/noSession");
            return false;
        }
    }

}
