package org.lyflexi.factoryPattern.abstractFactoryPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 16:21
 */
public interface IFactory {
    IApple createApple();
    IOrange createOrange();
}
