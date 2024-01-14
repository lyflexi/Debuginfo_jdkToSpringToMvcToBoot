package org.lyflexi.proxy;



import org.junit.Test;
import org.lyflexi.proxy.dynamic_proxy_manual_nonefile.mapper.UserMapper;
import org.lyflexi.proxy.dynamic_proxy_manual_nonefile.proxy.Proxy;

public class DynamicProxyManualNoneFileTest {

    @Test
    public void proxyTest() throws Exception {
        UserMapper userMapper = Proxy.newInstance(UserMapper.class);
        userMapper.getUserById(12);
    }
}
