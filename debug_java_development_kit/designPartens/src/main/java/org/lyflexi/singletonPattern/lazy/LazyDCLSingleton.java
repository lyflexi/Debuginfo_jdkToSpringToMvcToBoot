package org.lyflexi.singletonPattern.lazy;

/**
 * @Author: ly
 * @Date: 2024/3/13 20:17
 */

public class LazyDCLSingleton {
    private volatile static LazyDCLSingleton lazySingleton = null;

    private LazyDCLSingleton() {
    }

    public static LazyDCLSingleton getInstance(){
        if(null == lazySingleton){//1
            synchronized (LazyDCLSingleton.class){//2
                if(null == lazySingleton){//3
                    lazySingleton = new LazyDCLSingleton();//4
                }
            }
        }
        return lazySingleton;//5
    }
}

