package org.lyflexi.factoryPattern.simpleFactoryPatternByReflect;

/**
 * @Author: ly
 * @Date: 2024/3/13 16:07
 */
public class SimpleFactory {
    public IProduct createProduct(Class<? extends IProduct> clazz) throws Exception {
        if (null == clazz){
            throw new Exception("无法识别的产品");
        }
        return clazz.newInstance();
    }
}

