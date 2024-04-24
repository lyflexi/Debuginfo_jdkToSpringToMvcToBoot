package org.lyflexi.facadePattern;

/**
 * @Author: ly
 * @Date: 2024/4/13 17:29
 */
public class Facade2 {
    private SubSystemA systemA = new SubSystemA();
    private SubSystemB systemB = new SubSystemB();

    public void doAB(){
        this.systemA.doSomething();
        this.systemB.doSomething();
    }

}
