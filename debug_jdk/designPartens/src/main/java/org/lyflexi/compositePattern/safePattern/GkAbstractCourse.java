package org.lyflexi.compositePattern.safePattern;

/**
 * @Author: ly
 * @Date: 2024/4/13 17:07
 */
/**
 * 顶层抽象组件
 */
public abstract class GkAbstractCourse {
    protected String name;
    protected String score;

    public GkAbstractCourse(String name, String score) {
        this.name = name;
        this.score = score;
    }

    //接口隔离原则，safe
    public abstract void  info();
}

