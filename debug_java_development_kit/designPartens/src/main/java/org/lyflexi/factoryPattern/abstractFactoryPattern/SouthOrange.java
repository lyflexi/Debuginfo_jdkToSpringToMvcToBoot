package org.lyflexi.factoryPattern.abstractFactoryPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 16:21
 */
public class SouthOrange implements IOrange {
    @Override
    public void growOrange() {
        System.out.println("种植南方桔子");
    }
}
