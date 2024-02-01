package org.lyflexi.proxy;


import org.junit.Test;
import org.lyflexi.proxy.static_proxy.dao.IUserDao;
import org.lyflexi.proxy.static_proxy.dao.impl.UserDaoImpl;
import org.lyflexi.debug_jdk.design_partens.static_proxy.proxy.UserDaoProxy;
public class StaticProxyTest {

    @Test
    public void testDelete() {
        //目标对象
        IUserDao target = (IUserDao) new UserDaoImpl();
        //代理对象
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.delete(1);
    }
}
