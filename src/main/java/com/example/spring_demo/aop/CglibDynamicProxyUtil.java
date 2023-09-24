package com.example.spring_demo.aop;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxyUtil {
    private final Object target;

    public CglibDynamicProxyUtil(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        // 创建 CGLIB 增强对象
        Enhancer enhancer = new Enhancer();
        // 指定父类，也就是被代理的类
        Class<?> superClass = target.getClass();
        enhancer.setSuperclass(superClass);
        // 指定回调接口（拦截器）
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object source, Method method, Object[] args,
                                    MethodProxy methodProxy) throws Throwable {
                long startTime = System.currentTimeMillis();
                System.out.println("前");
                Object result = methodProxy.invokeSuper(source, args);
                long costTime = System.currentTimeMillis() - startTime;
                System.out.println("後");
                return result;
            }
        });
        // 创建代理对象
        return enhancer.create();
    }
}
