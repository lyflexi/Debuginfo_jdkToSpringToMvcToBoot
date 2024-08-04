package org.lyflexi.factoryPattern.simpleFactoryPatternByReflect;

/**
 * @Author: ly
 * @Date: 2024/3/13 16:07
 */

public class TestSimpleFactory {
    public static void main(String[] args) throws Exception {
        SimpleFactory factory = new SimpleFactory();
        IProduct apple = factory.createProduct(Apple.class);
        apple.grow();//输出：种植苹果

        IProduct orange = factory.createProduct(Orange.class);
        orange.grow();//输出：种植桔子
    }
}

