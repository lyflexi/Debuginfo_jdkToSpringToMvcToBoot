package org.lyflexi.compositePattern;

/**
 * @Author: ly
 * @Date: 2024/4/13 17:04
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝节点
 */
public class LevelCource extends GkAbstractCourse{
    private List<GkAbstractCourse> courseList = new ArrayList<>();
    private String name;
    private int level;

    public LevelCource(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(GkAbstractCourse course) {
        courseList.add(course);
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void info() throws Exception {
        System.out.println("课程:" + this.name);
        for (GkAbstractCourse course : courseList){
            for (int i=0;i<level;i++){
                System.out.print("  ");
            }
            System.out.print(">");
            course.info();
        }
    }
}

