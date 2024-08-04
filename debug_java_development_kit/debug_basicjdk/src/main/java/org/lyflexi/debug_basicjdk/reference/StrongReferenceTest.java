package org.lyflexi.debug_basicjdk.reference;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ly
 * @Date: 2024/2/24 10:29
 */
public class StrongReferenceTest {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        System.out.println("gc before: "+myObject);

        myObject = null;
        System.gc();//人工开启GC，一般不用

        //暂停毫秒
        try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("gc after: "+myObject);
    }
}
