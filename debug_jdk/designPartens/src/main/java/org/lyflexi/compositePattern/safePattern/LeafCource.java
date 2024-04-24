package org.lyflexi.compositePattern.safePattern;

/**
 * @Author: ly
 * @Date: 2024/4/13 17:07
 */
/**
 * 叶子节点
 */
public class LeafCource extends GkAbstractCourse {

    public LeafCource(String name,String score) {
        super(name,score);
    }

    @Override
    public void info() {
        System.out.println("课程:" + this.name + ",分数:" + this.score);
    }
}

