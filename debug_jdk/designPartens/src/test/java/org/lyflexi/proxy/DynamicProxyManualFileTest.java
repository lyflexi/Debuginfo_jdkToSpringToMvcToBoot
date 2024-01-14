package org.lyflexi.proxy;


import org.junit.jupiter.api.Test;
import org.lyflexi.proxy.dynamic_proxy_manual_file.mapper.UserMapper;
import org.lyflexi.proxy.dynamic_proxy_manual_file.proxy.Proxy;

public class DynamicProxyManualFileTest {

    @Test
    public void proxyTest() throws Exception {
        UserMapper userMapper = Proxy.newInstance(UserMapper.class);
        userMapper.getUserById(12);
    }
}
