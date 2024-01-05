package org.lyflexi.debug_springframework.dependencecircle;


import org.lyflexi.debug_springframework.dependencecircle.dependence_nonaop.Circle;
import org.lyflexi.debug_springframework.dependencecircle.dependence_nonaop.Loop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DependenceNonaopTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dependencecircle/dependence_nonaop.xml");
        Circle circle = (Circle)context.getBean("circle");
        Loop loop = (Loop) context.getBean("loop");
        System.out.println(circle.getClass().getTypeName());
        System.out.println(loop.getClass().getTypeName());
        circle.sayHello("LY");
    }
}
