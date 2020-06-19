package com.y.demo.config;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class GameConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorConfig())
                .addPathPatterns("/User/login/*")
                .addPathPatterns("/Equip/l_equip")
                .addPathPatterns("/Equip/delete");
    }
}
