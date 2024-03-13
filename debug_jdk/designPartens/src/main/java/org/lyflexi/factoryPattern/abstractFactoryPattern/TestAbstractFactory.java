package org.lyflexi.factoryPattern.abstractFactoryPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 16:21
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        IFactory southFarmFactory = new SouthFarmFactory();
        IApple apple = southFarmFactory.createApple();
        apple.growApple();//输出：种植南方苹果

        IOrange orange = southFarmFactory.createOrange();
        orange.growOrange();//输出：种植南方桔子
    }
}

