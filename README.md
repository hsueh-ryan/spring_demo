## 請求流程


:::success
DispatcherServlet也是一種servlet,他繼承了HttpServlet
FrameworkServlet改寫了HttpServlet的doGet/doPost方法,最終會調用doService抽象方法
DispatcherServlet會實現doService方法,最終會調用doDispatcher方法
每個request都會調用doDispatcher方法,裡面有個HandlerExecutionChain mappedHandler,會查詢匹配到可以處理該請求的controller
:::
