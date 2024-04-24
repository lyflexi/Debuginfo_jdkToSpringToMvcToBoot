package org.lyflexi.facadePattern;

/**
 * @Author: ly
 * @Date: 2024/4/13 17:29
 */
public class Facade1 {
    private SubSystemA systemA = new SubSystemA();
    private SubSystemB systemB = new SubSystemB();

    public void doA(){
        this.systemA.doSomething();
    }
    public void doB(){
        this.systemB.doSomething();
    }
}
