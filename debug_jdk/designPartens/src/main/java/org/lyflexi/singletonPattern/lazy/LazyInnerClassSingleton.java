package org.lyflexi.singletonPattern.lazy;

import java.io.Serializable;

/**
 * @Author: ly
 * @Date: 2024/3/13 20:18
 */

public class LazyInnerClassSingleton implements Serializable {

    private LazyInnerClassSingleton(){
        //防止反射攻击
        if(null != LazyHolder.LAZY){
            throw new RuntimeException("不允许构造多个实例");
        }
    }

    public static final LazyInnerClassSingleton getInstance(){
        return LazyHolder.LAZY;
    }

    //防止序列化破坏单例
    private Object readResolve(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}

