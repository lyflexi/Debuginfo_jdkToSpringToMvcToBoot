package org.lyflexi.factoryPattern.simpleFactoryPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 16:06
 */
public class Apple implements IProduct {
    @Override
    public void grow() {
        System.out.println("种植苹果");
    }
}
