package org.lyflexi.factoryPattern.abstractFactoryPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 16:21
 */
public class SouthFarmFactory implements IFactory {
    @Override
    public IApple createApple() {
        return new SouthApple();
    }

    @Override
    public IOrange createOrange() {
        return new SouthOrange();
    }
}
