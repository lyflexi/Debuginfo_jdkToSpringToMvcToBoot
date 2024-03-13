package org.lyflexi.builderPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:10
 */
/**
 * 建造者模式-抽象建造者(Builder)
 */
public abstract class HomeworkBuilder {
    public abstract HomeworkBuilder buildEasyQc(String easyQc);

    public abstract HomeworkBuilder buildNormalQc(String normalQc);

    public abstract HomeworkBuilder buildMediumQc(String mediumQc);

    public abstract HomeworkBuilder buildHardQc(String hardQc);

    public abstract Homework build();
}

