package org.lyflexi.singletonPattern.threadLocaled;

/**
 * @Author: ly
 * @Date: 2024/3/13 20:41
 */

public class ThreadLocalSingleton {
    private ThreadLocalSingleton() {

    }
    private static final ThreadLocal<ThreadLocalSingleton> singleton =
            new ThreadLocal<ThreadLocalSingleton>() {
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    public static ThreadLocalSingleton getInstance(){
        return singleton.get();
    }
}

