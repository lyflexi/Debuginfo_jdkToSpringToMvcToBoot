package org.lyflexi.factoryPattern.simpleFactoryPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 16:07
 */

public class TestSimpleFactory {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        IProduct apple = factory.createProduct("apple");
        apple.grow();//输出：种植苹果

        IProduct orange = factory.createProduct("orange");
        orange.grow();//输出：种植桔子
    }
}

