package org.lyflexi.proxy.dynamic_proxy_manual_nonefile_plus.proxy;

import java.lang.reflect.Method;

public interface InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args);

}