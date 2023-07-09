## 請求流程


:::success
DispatcherServlet也是一種servlet,他繼承了HttpServlet
FrameworkServlet改寫了HttpServlet的doGet/doPost方法,最終會調用doService抽象方法
DispatcherServlet會實現doService方法,最終會調用doDispatcher方法
每個request都會調用doDispatcher方法,裡面有個HandlerExecutionChain mappedHandler,會查詢匹配到可以處理該請求的controller
:::


### 過濾器和攔截器的區別
* 執行時機不同
  * Filter:進入Servlet容器（如Tomcat)後,請求進入servlet之前
  * Interceptor:進入servlet後,請求進入controller之前
* 執行方式不同
  * Filter的執行由Servlet容器回調完成
  * Interceptor通過動態代理（反射）的方式來執行
* 生命週期不同
  * Filter的生命週期由Servlet容器管理
  * 通過IoC容器來管理
* 使用範圍
  * Filter應用於所有Servlet容器中的Web應用程序，不僅限於Spring框架
    * servletRequest的編碼就是透過filter處理
  * Interceptor是Spring MVC框架的一部分，主要用於處理基於Spring的Web應用程序中的請求
