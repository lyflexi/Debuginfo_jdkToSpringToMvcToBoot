package org.lyflexi.debug_basicjdk.reference;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ly
 * @Date: 2024/2/24 10:41
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject());
        System.out.println("-----gc before 内存够用： "+weakReference.get());

        System.gc();
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("-----gc after 内存够用： "+weakReference.get());
    }
}
