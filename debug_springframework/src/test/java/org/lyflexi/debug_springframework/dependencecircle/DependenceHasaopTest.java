package org.lyflexi.debug_springframework.dependencecircle;


import org.lyflexi.debug_springframework.dependencecircle.dependence_hasaop.Circle;
import org.lyflexi.debug_springframework.dependencecircle.dependence_hasaop.Loop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DependenceHasaopTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dependencecircle/dependence_hasaop.xml");
        Circle circle = (Circle)context.getBean("circle");
        Loop loop = (Loop) context.getBean("loop");
        System.out.println(circle.getClass().getTypeName());
        System.out.println(loop.getClass().getTypeName());
        circle.sayHello("ly");
    }
}
