package com.example.spring_demo.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
@Order(2)
@Component
public class OncePerRequestMyFilter2 extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("執行 OncePerRequestMyFilter2 enter-----");
        filterChain.doFilter(request,response);
        System.out.println("執行 OncePerRequestMyFilter2 exit-----");
    }


}
