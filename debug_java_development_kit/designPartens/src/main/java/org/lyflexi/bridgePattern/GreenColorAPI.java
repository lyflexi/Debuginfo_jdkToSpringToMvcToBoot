package org.lyflexi.bridgePattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 12:07
 */
public class GreenColorAPI implements ColorAPI {
    @Override
    public void paint() {
        System.out.println("画上绿色");
    }
}