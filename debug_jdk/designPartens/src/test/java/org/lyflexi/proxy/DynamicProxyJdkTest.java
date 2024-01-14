package org.lyflexi.proxy;


import org.junit.Test;
import org.lyflexi.proxy.dynamic_proxy_jdk.mapper.UserMapper;
import org.lyflexi.proxy.dynamic_proxy_jdk.proxy.MapperProxy;
import org.lyflexi.proxy.dynamic_proxy_jdk.proxy.MapperProxyFactory;

public class DynamicProxyJdkTest {

    @Test
    public void testProxy() {

        // 代理逻辑处理handler
        MapperProxy mapperProxy = new MapperProxy(UserMapper.class);

        // 代理实例工厂
        MapperProxyFactory proxyFactory = new MapperProxyFactory(UserMapper.class);

        // 获取代理对象
        UserMapper mapper = (UserMapper) proxyFactory.newInstance(mapperProxy);

        int delete = mapper.delete(1);
        System.out.println("result = " + delete);
    }
}
