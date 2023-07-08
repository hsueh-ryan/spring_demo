package com.example.spring_demo.controller;

import com.example.spring_demo.model.RequestTest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public void getMethod(){
        System.out.println("do getMethod");
    }

    @PostMapping("/test")
    public void postMethod(@RequestBody RequestTest requestTest){
        System.out.println("do postMethod");
        System.out.println(requestTest.getTest());
    }
}
