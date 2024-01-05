package org.lyflexi;


import org.lyflexi.circle.C;
import org.lyflexi.circle.Circle;
import org.lyflexi.circle.Loop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DependenceHasaopRemovesfTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dependence_hasaop_removesf.xml");
        Circle circle = (Circle)context.getBean("circle");
        Loop loop = (Loop) context.getBean("loop");
        C c = (C) context.getBean("c");
        System.out.println(circle.getClass().getTypeName());
        System.out.println(loop.getClass().getTypeName());
        System.out.println(c.getClass().getTypeName());
        circle.sayHello("ly");
    }
}
