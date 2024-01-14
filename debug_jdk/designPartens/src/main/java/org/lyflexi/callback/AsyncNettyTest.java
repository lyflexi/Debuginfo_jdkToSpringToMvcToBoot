package org.lyflexi.callback;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class AsyncNettyTest {

    static ExecutorService es = Executors.newFixedThreadPool(2);

    public static void doStm(final org.lyflexi.debug_jdk.design_partens.callback.ICallback callback) {
        // 初始化一个线程
        Thread t = new Thread() {
            public void run() {

                // 这里是业务逻辑处理
                System.out.println("子线任务执行:"+Thread.currentThread().getId());

                // 为了能看出效果 ，让当前线程阻塞5秒
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 处理完业务逻辑，
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("a1", "这是我返回的参数字符串...");
                callback.callback(params);
            };
        };

        es.execute(t);
        //一定要调用这个方法，不然executorService.isTerminated()永远不为true
        es.shutdown();
    }

    public static void main(String[] args) {
        doStm((params)->{
            System.out.println("单个线程也已经处理完毕了，返回参数a1=" + params.get("a1"));
        });

        System.out.println("主线任务已经执行完了:"+Thread.currentThread().getId());
    }

}