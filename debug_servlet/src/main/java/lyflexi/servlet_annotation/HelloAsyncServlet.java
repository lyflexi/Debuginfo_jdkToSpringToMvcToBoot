package lyflexi.servlet_annotation;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/async", asyncSupported = true)
public class HelloAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、支持异步处理asyncSupported=true
        //2、开启异步模式
        System.out.println("主线程开始。。。" + Thread.currentThread() + "==>" + System.currentTimeMillis());
        AsyncContext startAsync = req.startAsync();

        //3、业务逻辑进行异步处理;开始异步处理
        startAsync.start(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("副线程开始。。。" + Thread.currentThread() + "==>" + System.currentTimeMillis());
                    sayHello();
                    startAsync.complete();
//                    //获取到异步上下文,这里不好使？
//                    AsyncContext asyncContext = req.getAsyncContext();
//                    //4、获取响应
//                    ServletResponse response = asyncContext.getResponse();
                    ServletResponse response = startAsync.getResponse();
                    response.getWriter().write("hello async...");
                    System.out.println("副线程结束。。。" + Thread.currentThread() + "==>" + System.currentTimeMillis());
                } catch (Exception e) {
                }
            }
        });
        System.out.println("主线程结束。。。" + Thread.currentThread() + "==>" + System.currentTimeMillis());
    }

    public void sayHello() throws Exception {
        System.out.println(Thread.currentThread() + " processing...");
        Thread.sleep(1000);//1s
    }
}
