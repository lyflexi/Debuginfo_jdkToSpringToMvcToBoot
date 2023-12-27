package org.lyflexi.debug_jdk.design_partens.proxy;


import org.junit.jupiter.api.Test;
import org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_nonefile.mapper.UserMapper;
import org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_nonefile.proxy.Proxy;

public class DynamicProxyManualNoneFileTest {

    @Test
    public void proxyTest() throws Exception {
        UserMapper userMapper = Proxy.newInstance(UserMapper.class);
        userMapper.getUserById(12);
    }
}
