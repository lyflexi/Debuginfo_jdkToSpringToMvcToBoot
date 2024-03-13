package org.lyflexi.factoryPattern.fatoryMethodPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 16:11
 */
public class OrangeFactory implements IFarmFactory {
    @Override
    public IProduct create() {
        return new Orange();
    }
}
