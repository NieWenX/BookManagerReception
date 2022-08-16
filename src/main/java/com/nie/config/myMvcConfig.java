package com.nie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class myMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new loginHandlerInterceptor())
                    .addPathPatterns("/pages/**","/index")
                    .excludePathPatterns("/login","/toLogin","toLogout");
    }


}
