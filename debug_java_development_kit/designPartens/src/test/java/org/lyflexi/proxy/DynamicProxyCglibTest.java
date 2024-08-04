package org.lyflexi.proxy;


import net.sf.cglib.proxy.MethodInterceptor;

import org.junit.Test;
import org.lyflexi.proxy.dynamic_proxy_cglib.dao.IUserDao;
import org.lyflexi.proxy.dynamic_proxy_cglib.proxy.DaoMethodInterceptor;
import org.lyflexi.proxy.dynamic_proxy_cglib.proxy.DaoProxyFactory;


public class DynamicProxyCglibTest {

    @Test
    public void cglibTest() {
        MethodInterceptor interceptor = new DaoMethodInterceptor();

        IUserDao userDao = DaoProxyFactory.newInstance(IUserDao.class, interceptor);
        int result = userDao.delete(1);
        System.out.println("result = " + result);
    }
}
