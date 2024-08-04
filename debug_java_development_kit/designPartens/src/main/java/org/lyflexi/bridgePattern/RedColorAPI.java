package org.lyflexi.bridgePattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 12:05
 */
public class RedColorAPI implements ColorAPI
{
    @Override
    public void paint() {
        System.out.println("画上红色");
    }
}
