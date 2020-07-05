package com.game.game.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VIPInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Integer vip = (Integer) request.getSession().getAttribute("VIP");
        if (vip == 1){
            return true;
        }
        request.getRequestDispatcher("/Jump/success").forward(request,response);
        return false;
    }
}
