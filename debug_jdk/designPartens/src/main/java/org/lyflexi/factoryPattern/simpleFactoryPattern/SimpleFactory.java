package org.lyflexi.factoryPattern.simpleFactoryPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 16:07
 */
public class SimpleFactory {
    public IProduct createProduct(String productType){
        if("apple".equals(productType)){
            return new Apple();
        }else if("orange".equals(productType)){
            return new Orange();
        }
        return null;
    }
}

