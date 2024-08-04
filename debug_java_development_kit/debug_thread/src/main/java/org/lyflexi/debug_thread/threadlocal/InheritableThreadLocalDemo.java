package org.lyflexi.debug_thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/7/27 9:39
 */
public class InheritableThreadLocalDemo {
    private static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("mainThread");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String value = threadLocal.get();
                System.out.println("value(thread):"+value);
            }
        });
        try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        threadLocal.set("mainThreadModify");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String value = threadLocal.get();
                System.out.println("value(thread2):"+value);
            }
        });
        thread.start();
        thread2.start();
    }
}

