package org.lyflexi.compositePattern;

/**
 * @Author: ly
 * @Date: 2024/4/13 17:04
 */

public class TestTransparency {
    public static void main(String[] args) throws Exception {
        GkAbstractCourse ywCourse = new LeafCource("叶子节点语文","150");
        GkAbstractCourse sxCourse = new LeafCource("叶子节点数学","150");
        GkAbstractCourse yyCourse = new LeafCource("叶子节点英语","150");

        GkAbstractCourse wlCourse = new LeafCource("叶子节点物理","110");
        GkAbstractCourse hxCourse = new LeafCource("叶子节点化学","100");
        GkAbstractCourse swCourse = new LeafCource("叶子节点生物","90");

        GkAbstractCourse lzCourse = new LevelCource("理综",2);
        lzCourse.addChild(wlCourse);
        lzCourse.addChild(hxCourse);
        lzCourse.addChild(swCourse);

        GkAbstractCourse gkCourse = new LevelCource("理科高考科目",1);
        gkCourse.addChild(ywCourse);
        gkCourse.addChild(sxCourse);
        gkCourse.addChild(yyCourse);
        gkCourse.addChild(lzCourse);

        gkCourse.info();
    }
}

