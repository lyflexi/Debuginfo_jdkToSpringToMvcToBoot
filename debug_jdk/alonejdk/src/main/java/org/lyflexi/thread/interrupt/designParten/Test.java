package org.lyflexi.thread.interrupt.designParten;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: ly
 * @Date: 2024/3/14 11:35
 */

public class Test {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();
        Thread.sleep(3500);
        System.out.println("停止监控");

        tpt.stop();
    }
}
