package com.example.spring_demo.config;

import com.example.spring_demo.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                //哪些路徑生效,所有請求都會被攔截,包含靜態資源
                .addPathPatterns("/**")
                //哪些路經排除
                .excludePathPatterns("/test");
    }
}
