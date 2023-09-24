package com.example.spring_demo.aop;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class ProxyUtil {
    public ProxyUtil(Object target) {
        this.target = target;
    }

    //目標對象
    private final Object target;

    //此為jdk動態代理  要求必須有接口
    //例外還有cglib動態代理 要求必須有父類繼承關係
    public Object getProxy(){
      /*  ClassLoader loader(類加載器)
            代理對象為通過jdk動態代理生成的對象,對象依賴於類存在
            一個類要被加載執行要有類加載器,此參數為設置當前類所數的類加載器
            此處使用與當前對象同一個類加載器m,一個類加載器可以加載多的類所以拿來共用
            this.getClass().getClassLoader()取得當前對象的類加載器
        Class<?>[] interfaces,
            代理對象想要理解需要幫我們處理什麼method,必須從interface來知道我們有什麼method
            所以必須取得目標對象接口的method,所生成的代理類會與目標對象實現相同接口
            target.getClass().getInterfaces()可以取得目標對象所實現的接口
        InvocationHandler h
            要在反射中執行方法為使用invoke
            因為實現目標接口,所以方法為抽象,所以要寫實現的方法

        在java裡所有動態生成的代理都會繼承proxy類實現目標對象接口

       */

        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {

            //代理對象實現功能的方式
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * Object proxy(代理對象)
                 * Method method(方法)
                 * Object[] args(參數)
                 */
                //代理模式必須保證與原本的對象執行結果一致,所以還是會掉用原本對象的method
                //此處為什麼方法的執行,用什麼對象來調用,用什麼參數
                System.out.println("前");
                Object invoke = method.invoke(target, args);
                System.out.println("後");
                return invoke;
            }
        });
    }
}
