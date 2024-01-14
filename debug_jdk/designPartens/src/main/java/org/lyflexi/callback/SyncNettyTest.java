package org.lyflexi.callback;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class SyncNettyTest {
    private static ExecutorService es = Executors.newFixedThreadPool(2);


    public static void sysFunc(final org.lyflexi.debug_jdk.design_partens.callback.ICallback callback) {
        Callable<Netty> c = new Callable<Netty>() {

            @Override
            public Netty call() throws Exception {
                System.out.println("子线任务执行:"+Thread.currentThread().getId());
                //这里是你的业务逻辑处理

                //让当前线程阻塞1秒看下效果
                Thread.sleep(1000);
                return new Netty("张三");
            }
        };

        //记得要用submit，执行Callable对象
        Future<Netty> fn = es.submit(c);
        //一定要调用这个方法，不然executorService.isTerminated()永远不为true
        es.shutdown();

        //无限循环等待任务处理完毕  如果已经处理完毕 isDone返回true
        while (!fn.isDone()) {
            try {
                //子线程返回的结果
                Netty nt = fn.get();//阻塞在这里
                System.out.println("future获取返回值阻塞结束:"+nt.name);
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("a1", "这是我返回的参数字符串...");
                callback.callback(params);


            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        sysFunc((params)->{
            System.out.println("单个线程也已经处理完毕了，返回参数a1=" + params.get("a1"));
        });

        System.out.println("主线任务已经执行完了:"+Thread.currentThread().getId());
    }



    static class Netty {
        private String name;
        private Netty(String name) {
            this.name = name;
        }
    }

}
