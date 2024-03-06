package org.lyflexi.debug_springframework.aop;

/**
 * @Author: ly
 * @Date: 2024/3/3 20:14
 */
public class ImpCalculator implements MathCalculator{
    @Override
    public int div(int i, int j) {
        System.out.println("MathCalculator...div...");
        return i / j;
    }
}
