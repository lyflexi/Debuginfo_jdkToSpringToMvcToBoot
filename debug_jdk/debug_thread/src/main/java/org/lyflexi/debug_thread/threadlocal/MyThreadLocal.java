package org.lyflexi.debug_thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: ly
 * @Date: 2024/2/22 10:12
 */
public class MyThreadLocal {

    public static void main(String[] args) throws InterruptedException
    {
        MyData myData = new MyData();

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        try
        {
            for (int i = 0; i < 10; i++) {
                threadPool.submit(() -> {
                    try {
                        Integer beforeInt = myData.threadLocalField.get();
                        myData.add();
                        Integer afterInt = myData.threadLocalField.get();
                        System.out.println(Thread.currentThread().getName()+"\t"+"beforeInt:"+beforeInt+"\t afterInt: "+afterInt);
                    } finally {
                        myData.threadLocalField.remove();
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
    static class MyData
    {
        ThreadLocal<Integer> threadLocalField = ThreadLocal.withInitial(() -> 0);
        public void add()
        {
            threadLocalField.set(1 + threadLocalField.get());
        }
    }


}
