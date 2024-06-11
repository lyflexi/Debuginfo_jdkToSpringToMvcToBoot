package org.lyflexi.debug_springboot.filter;

/**
 * @Author: ly
 * @Date: 2024/6/11 22:03
 */
import jakarta.servlet.*;
import jakarta.servlet.FilterConfig;

import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        // 这里可以进行过滤器的初始化操作
        System.out.println("LoggingFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // 请求前处理
        System.out.println("LoggingFilter: FilterChain之前");

        // 继续执行下一个过滤器或者目标Servlet
        chain.doFilter(request, response);

        // 请求后处理
        System.out.println("LoggingFilter: FilterChain之后");
    }

    @Override
    public void destroy() {
        // 进行资源清理工作
        System.out.println("LoggingFilter 销毁");
    }
}