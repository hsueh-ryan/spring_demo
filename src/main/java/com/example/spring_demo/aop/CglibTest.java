package com.example.spring_demo.aop;

public class CglibTest {

    public static void main(String[] args) {
        CglibDynamicProxyUtil cglibDynamicProxyUtil = new CglibDynamicProxyUtil(new MyTarget2());
        MyTarget2 proxy = (MyTarget2) cglibDynamicProxyUtil.getProxy();
        proxy.myTargetMethod();
    }
}
