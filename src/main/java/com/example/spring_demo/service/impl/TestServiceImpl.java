package com.example.spring_demo.service.impl;

import com.example.spring_demo.service.MyService;
import com.example.spring_demo.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    private final MyService myService;

    public TestServiceImpl(MyServiceImpl1 myService) {
        this.myService = myService;
    }

    public void method(){
        System.out.println("service method process");
    }
}
