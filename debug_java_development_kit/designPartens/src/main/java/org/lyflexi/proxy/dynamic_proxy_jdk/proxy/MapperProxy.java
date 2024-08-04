package org.lyflexi.proxy.dynamic_proxy_jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理逻辑实现
 * 此proxy不仅仅只是适用UserMapper，还适用于其他所有的Mapper
 */
public class MapperProxy<T> implements InvocationHandler {

    private final Class<T> mapperInterface;

    public MapperProxy(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     *
     * @param proxy     代理类自身，链式编程的情况下会用到
     * @param method    目标方法
     * @param args      目标方法参数
     * @return          数据库执行结果
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // TODO 一些其他的处理

        return execute(args);
    }

    /**
     * mapper真正的数据操作，可参考的mybatis MapperProxy中invoke方法的做法 ：
     *      final MapperMethod mapperMethod = cachedMapperMethod(method);
     *      return mapperMethod.execute(sqlSession, args);
     * @param args
     * @return      数据库执行结果
     */
    public Object execute(Object[] args) {

        System.out.println("数据库操作, 并获取执行结果...");
        Object result = 1;      // 1表示数据库操作返回结果；由于数据库操作并未实现，这里写死成1
        return result;
    }

}
