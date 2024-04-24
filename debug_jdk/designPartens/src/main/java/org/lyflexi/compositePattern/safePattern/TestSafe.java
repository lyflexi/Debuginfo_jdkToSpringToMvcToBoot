package org.lyflexi.compositePattern.safePattern;

/**
 * @Author: ly
 * @Date: 2024/4/13 17:08
 */

public class TestSafe {
    public static void main(String[] args) throws Exception {
        LeafCource ywCourse = new LeafCource("叶子节点语文","150");
        LeafCource sxCourse = new LeafCource("叶子节点数学","150");
        LeafCource yyCourse = new LeafCource("叶子节点英语","150");

        LeafCource wlCourse = new LeafCource("叶子节点物理","110");
        LeafCource hxCourse = new LeafCource("叶子节点化学","100");
        LeafCource swCourse = new LeafCource("叶子节点生物","90");

        LevelCource lzCourse = new LevelCource("理综","300",2);
        lzCourse.addChild(wlCourse);
        lzCourse.addChild(hxCourse);
        lzCourse.addChild(swCourse);

        LevelCource gkCourse = new LevelCource("理科高考","750",1);
        gkCourse.addChild(ywCourse);
        gkCourse.addChild(sxCourse);
        gkCourse.addChild(yyCourse);

        gkCourse.addChild(lzCourse);
        gkCourse.info();
    }
//    安全模式下叶子节点不具备addChild功能，所以无法调用，
//    而透明模式下addChild可以被调用，但是调用之后显示不支持，这就是这两种写法最大的区别。
}

