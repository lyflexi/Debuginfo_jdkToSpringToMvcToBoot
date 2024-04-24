package org.lyflexi.compositePattern;

/**
 * @Author: ly
 * @Date: 2024/4/13 17:04
 */
/**
 * 普通科目类(叶子节点)
 */
public class LeafCource extends GkAbstractCourse {
    private String name;//课程名称
    private String score;//课程分数

    public LeafCource(String name, String score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void info() {
        System.out.println("课程:" + this.name + ",分数:" + score);
    }
}
