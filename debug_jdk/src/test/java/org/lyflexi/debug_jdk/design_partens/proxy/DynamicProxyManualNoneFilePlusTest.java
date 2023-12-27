package org.lyflexi.debug_jdk.design_partens.proxy;

import org.junit.jupiter.api.Test;
import org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_nonefile_plus.mapper.UserMapper;
import org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_nonefile_plus.proxy.DaoProxy;
import org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_nonefile_plus.proxy.InvocationHandler;
import org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_nonefile_plus.proxy.Proxy;

public class DynamicProxyManualNoneFilePlusTest {
    @Test
    public void test() throws Exception {
        // InvocationHandler mapperProxy = new MapperProxy();
        InvocationHandler mapperProxy = new DaoProxy();
        System.out.println(mapperProxy);
        UserMapper userMapper = Proxy.newInstance(UserMapper.class, mapperProxy);
        System.out.println(userMapper.delete(1));
        System.out.println("=================");
        System.out.println(userMapper.getUserById(1));
    }
}
