package org.lyflexi.bridgePattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 12:06
 */
public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.print("我是圆形");
        colorAPI.paint();
    }
}
