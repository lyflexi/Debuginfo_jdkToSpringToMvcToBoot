package org.lyflexi.singletonPattern.enumerated;

/**
 * @Author: ly
 * @Date: 2024/3/13 20:36
 */

public enum EnumSingleton {
    INSTANCE;

    // 添加需要的其他的无关的成员变量或方法
    private Object data;
    // 添加需要的其他的无关的成员变量或方法
    public Object getData() {
        return data;
    }
    // 添加需要的其他的无关的成员变量或方法
    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

}

