package com.example.spring_demo.config;

import com.example.spring_demo.interceptor.MyInterceptor1;
import com.example.spring_demo.interceptor.MyInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    private final MyInterceptor1 myInterceptor1;
    private final MyInterceptor2 myInterceptor2;

    public MyConfig(MyInterceptor1 myInterceptor1, MyInterceptor2 myInterceptor2) {
        this.myInterceptor1 = myInterceptor1;
        this.myInterceptor2 = myInterceptor2;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor1)
                //哪些路徑生效,所有請求都會被攔截,包含靜態資源
                .addPathPatterns("/**")
                //哪些路經排除
                .excludePathPatterns("/test")
                //設定執行順序
                .order(1);
        registry.addInterceptor(myInterceptor2)
                //哪些路徑生效,所有請求都會被攔截,包含靜態資源
                .addPathPatterns("/**")
                //哪些路經排除
                .excludePathPatterns("/test")
                //設定執行順序
                .order(1);
    }
}
