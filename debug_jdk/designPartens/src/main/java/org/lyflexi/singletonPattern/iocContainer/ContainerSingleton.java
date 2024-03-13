package org.lyflexi.singletonPattern.iocContainer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: ly
 * @Date: 2024/3/13 20:38
 */
public class ContainerSingleton {
    private ContainerSingleton(){
    }

    private static Map<String,Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String className){
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className,obj);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return obj;
            }
            return ioc.get(className);
        }
    }
}

