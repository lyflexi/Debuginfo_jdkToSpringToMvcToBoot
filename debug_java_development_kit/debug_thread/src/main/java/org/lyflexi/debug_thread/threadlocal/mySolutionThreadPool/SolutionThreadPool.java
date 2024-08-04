package org.lyflexi.debug_thread.threadlocal.mySolutionThreadPool;

import java.util.concurrent.*;

public class SolutionThreadPool {
    private final ThreadLocal<String> contextHolder = ThreadLocal.withInitial(() -> "Initial Value");

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 创建SolutionThreadPool实例
        SolutionThreadPool solution = new SolutionThreadPool();


        // 提交任务到线程池
        Future<String> future = executorService.submit(new DecorateTask("Task Value",solution.contextHolder));

        // 等待任务完成并获取结果
        String result = future.get();

        // 打印结果
        System.out.println("Result: " + result);

        // 关闭线程池
        executorService.shutdown();
    }
}