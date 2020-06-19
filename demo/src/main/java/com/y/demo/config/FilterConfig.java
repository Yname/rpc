package com.y.demo.config;

import org.springframework.context.annotation.Configuration;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
@WebFilter(description = "LoginFilter",urlPatterns = "/*")
//@Order(value = 0)
//@Component
public class FilterConfig implements Filter {

//    public static final Set<String> Allows_Path =
//            Collections.unmodifiableSet(new HashSet<>(Arrays.asList("/User/addUser",
//                    "/User/login")));

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Integer phoneId = (Integer) request.getSession().getAttribute("PhoneId");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String requestURI = request.getRequestURI();

        boolean contains =
                (requestURI.equals("/User/addUser") ||
                        requestURI.equals("/User/loginTo") ||
                        requestURI.equals("/NUser/login") ||
                        requestURI.equals("/NUser/register"));


        if (phoneId != null || contains ){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            servletRequest.getRequestDispatcher("/User/l_index").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
