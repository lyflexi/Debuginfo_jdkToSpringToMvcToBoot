package org.lyflexi.builderPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:11
 */

/**
 * 建造者模式-具体建造者(ConcreteBuilder)
 */
public class ConcreateBuilder extends HomeworkBuilder {
    private Homework homework;

    public ConcreateBuilder(Homework homework) {
        this.homework = homework;
    }

    @Override
    public HomeworkBuilder buildEasyQc(String easyQc) {
        homework.setEasyQc(easyQc);
        return this;
    }

    @Override
    public HomeworkBuilder buildNormalQc(String normalQc) {
        homework.setNormalQc(normalQc);
        return this;
    }

    @Override
    public HomeworkBuilder buildMediumQc(String mediumQc) {
        homework.setMediumQc(mediumQc);
        return this;
    }

    @Override
    public HomeworkBuilder buildHardQc(String hardQc) {
        homework.setHardQc(hardQc);
        return this;
    }

    @Override
    public Homework build() {
        return homework;
    }
}

