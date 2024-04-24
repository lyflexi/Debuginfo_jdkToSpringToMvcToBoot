package org.lyflexi.facadePattern;

/**
 * @Author: ly
 * @Date: 2024/4/13 17:30
 */

//门面模式
public class TestFacade {
    public static void main(String[] args) {
        Facade1 facade1 = new Facade1();
        facade1.doA();
        facade1.doB();


        Facade2 facade2 = new Facade2();
        facade2.doAB();
    }
}
