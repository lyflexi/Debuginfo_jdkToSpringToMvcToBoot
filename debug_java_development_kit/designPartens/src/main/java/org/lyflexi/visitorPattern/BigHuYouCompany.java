package org.lyflexi.visitorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/4/22 14:49
 */

/*
* 访问者模式试图解决如下问题：
* 一个类农场里面包含各种元素，例如有大雁，狗子，鸭子。而每个元素的操作却经常变换，一会让大雁排成一字，一会让大雁排成人字。当大雁排成一字的时候狗子要排成S形状，鸭子要排成B形状，当大雁排成人字时候狗子要叫两声，鸭子要跳起来...。
* 同时对农场这类有要求，第一：可以迭代这些元素，第二：里面的元素不能频繁变动，你不能一会把鸭子杀了吃了，一会又买回一匹马...，如果是这样的话就不适合使用Visitor模式
* */

//    BigHuYouCompany就好比农场
public class BigHuYouCompany {
    private List<CorporateSlave> employee= new ArrayList<>();

    public BigHuYouCompany() {
        employee.add(new Programmer("王二狗"));
        employee.add(new HumanSource("上官无需"));
        employee.add(new Tester("牛翠花"));
    }

    public void startProject(CorporateSlaveVisitor visitor){
        for (CorporateSlave slave : employee) {
            slave.accept(visitor);
        }
    }
}
