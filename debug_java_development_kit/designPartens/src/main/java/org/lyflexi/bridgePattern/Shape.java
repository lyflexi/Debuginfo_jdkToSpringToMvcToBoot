package org.lyflexi.bridgePattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 12:05
 */
//base抽象类
public abstract class Shape {
    protected ColorAPI colorAPI;    //添加一个颜色的成员变量以调用ColorAPI 的方法来实现给不同的形状上色

    public void setDrawAPI(ColorAPI colorAPI) {      //注入颜色成员变量
        this.colorAPI= colorAPI;
    }

    public abstract void draw();
}

