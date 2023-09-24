package com.example.spring_demo.aop;

public class Test {

    public static void main(String[] args) {
        ProxyUtil proxyUtil = new ProxyUtil(new MyTargetImpl());
        MyTarget proxy = (MyTarget)proxyUtil.getProxy();

        proxy.myTarget();
    }



}
