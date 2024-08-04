package org.lyflexi.debug_basicjdk.superTest;

/**
 * @Author: ly
 * @Date: 2024/1/12 12:55
 */
public class Derive extends Base{
    public void getName(){
        System.out.println("this.name="+this.name);
    }

    public static void main(String[] args) {
        Derive derive = new Derive();
        derive.getName();
    }

}
