package org.lyflexi.proxy.dynamic_proxy_cglib.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理业务实现
 * 在此增加增强处理
 */
public class DaoMethodInterceptor implements MethodInterceptor {

    /**
     * 代理逻辑方法
     * @param proxy 代理对象
     * @param method 方法对象
     * @param args 方法参数
     * @param methodProxy 方法代理
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = execute(args);
        return  result;
    }

    /**
     * 可以定制，看我们自己的需求来定；
     * 可以增加参数、可以调用目标方法（代理目标对象而不是接口）、调用目标方法前后织入增强处理等等
     *
     * 本示例只是展示流程
     * @param args
     * @return
     */
    private Object execute(Object[] args) {
        // TODO 进行数据库操作，并获取返回值
        System.out.println("进行数据库操作, 并返回操作结果...");
        int returnValue = 1;            // 具体的数据库操作
        return returnValue;
    }
}
