package org.lyflexi.bridgePattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 12:07
 */
public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("我是三角形");
        colorAPI.paint();
    }
}

