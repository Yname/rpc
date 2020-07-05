package com.game.game.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class AllInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/User/*")
                .addPathPatterns("/Jump/*")
                .excludePathPatterns("/User/login")
//                .excludePathPatterns("/User/index")
                .excludePathPatterns("/User/register")
                .excludePathPatterns("/Jump/register")
                .excludePathPatterns("/Jump/index");

        registry.addInterceptor(new VIPInterceptor())
                .addPathPatterns("/Jump/VipSuccess");
    }


}
