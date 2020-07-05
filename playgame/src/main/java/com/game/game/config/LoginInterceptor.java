package com.game.game.config;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userid = (String) request.getSession().getAttribute("USERID");
        if (userid != null){
            return true;
        }
        request.getRequestDispatcher("/User/index").forward(request,response);
        return false;
//        false拦截器后不放行，true拦截后依然放行
    }
}
