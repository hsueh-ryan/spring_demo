package com.example.spring_demo.filter;

import com.example.spring_demo.service.impl.TestServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


//@Component
//@WebFilter
public class MyFilter1 implements Filter {

    private final TestServiceImpl testService;

    public MyFilter1(TestServiceImpl testService) {
        this.testService = testService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("my filter init ----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("執行 my filter ----");
        testService.method();
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("my filter destroy ----");
    }
}
