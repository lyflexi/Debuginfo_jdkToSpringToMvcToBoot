package org.lyflexi.factoryPattern.simpleFactoryPatternByReflect;

/**
 * @Author: ly
 * @Date: 2024/3/13 16:07
 */
public class Orange implements IProduct {
    @Override
    public void grow() {
        System.out.println("种植桔子");
    }
}
