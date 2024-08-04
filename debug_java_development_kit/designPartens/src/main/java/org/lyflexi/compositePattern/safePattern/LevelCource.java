package org.lyflexi.compositePattern.safePattern;

/**
 * @Author: ly
 * @Date: 2024/4/13 17:08
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝节点
 */
public class LevelCource extends GkAbstractCourse{
    private List<GkAbstractCourse> courseList = new ArrayList<>();
    private int level;

    public LevelCource(String name, String score,int level) {
        super(name,score);
        this.level = level;
    }

    public void addChild(GkAbstractCourse course) {
        courseList.add(course);
    }

    @Override
    public void info() {
        System.out.println("课程:" + this.name + ",分数：" + this.score);
        for (GkAbstractCourse course : courseList){
            for (int i=0;i<level;i++){
                System.out.print("  ");
            }
            System.out.print(">");
            course.info();
        }
    }
}

