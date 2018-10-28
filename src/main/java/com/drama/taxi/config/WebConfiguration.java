package com.drama.taxi.config;

import com.drama.taxi.utils.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// WebMvcConfigurer 를 구현하는 클래스는 Spring MVC 를 확장할 수 있는
// 기능을 가진다.
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /*로그인 하지 않아 세션이 없는 경우 다음 URL로 접근을 막는다.*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/passenger")
                .addPathPatterns("/driver")
                .addPathPatterns("/booking/form"); //URL로 접근할 수 없게 패턴을 지정.
    }

}