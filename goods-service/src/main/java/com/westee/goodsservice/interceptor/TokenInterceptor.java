package com.westee.goodsservice.interceptor;

import com.westee.goodsservice.service.TokenContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION); // 获取header中的Token
        if (token != null) {
            TokenContext.setCurrentToken(token);
        }
        return true; // 继续处理请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        TokenContext.clearCurrentToken();
    }

}
