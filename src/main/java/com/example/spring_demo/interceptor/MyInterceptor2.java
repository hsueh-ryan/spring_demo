package com.example.spring_demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 需要撰寫配置檔註冊攔截器
 */


@Component
public class MyInterceptor2 implements HandlerInterceptor {


    /**
     * 目標方法執行之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String test = (String) request.getAttribute("test");
        System.out.println("MyInterceptor2 print attribute " + test);
        System.out.println("執行了 MyInterceptor2 preHandle");
//        if (params == null) {
//            //攔截
//            return false;
//        }

        //放行
        return true;
    }

    /**
     * 目標方法執行之後
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("執行了 MyInterceptor2 postHandle");
    }

    /**
     * 頁面渲染之後
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("執行了 MyInterceptor2 afterCompletion");
    }
}
