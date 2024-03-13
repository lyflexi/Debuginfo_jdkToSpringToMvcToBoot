package org.lyflexi.singletonPattern.threadLocaled;

/**
 * @Author: ly
 * @Date: 2024/3/13 20:41
 */
public class ThreadLocalSingletonTest {

    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());//主线程中唯一
        System.out.println(ThreadLocalSingleton.getInstance());//主线程中唯一

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + ":" + singleton);//子线程中singleton唯一，但不等于主线程中singleton
            }
        });
        t1.start();
    }
}

