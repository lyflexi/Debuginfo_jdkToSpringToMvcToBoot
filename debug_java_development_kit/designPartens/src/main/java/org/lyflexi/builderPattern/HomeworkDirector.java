package org.lyflexi.builderPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:11
 */


import com.alibaba.fastjson.JSONObject;

/**
 * 建造者模式-调用者(Director)
 */
public class HomeworkDirector {
    public static void main(String[] args) {
        Homework homework = new Homework();
        HomeworkBuilder homeworkBuilder = new ConcreateBuilder(homework);
        homeworkBuilder.buildEasyQc("我是一道简单题目")
                .buildNormalQc("我是一道标准难度题目")
                .buildMediumQc("我是一道中等难度题目")
                .buildHardQc("我是一道高难度题目");
        homework = homeworkBuilder.build();
        System.out.println(JSONObject.toJSONString(homework));
    }
}

