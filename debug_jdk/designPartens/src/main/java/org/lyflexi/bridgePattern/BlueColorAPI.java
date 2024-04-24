package org.lyflexi.bridgePattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 12:05
 */
public class BlueColorAPI implements ColorAPI {
    @Override
    public void paint() {
        System.out.println("画上蓝色");
    }
}
