package org.lyflexi.debug_basicjdk.reference;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ly
 * @Date: 2024/2/24 10:32
 */
public class SoftReferenceTest {

    public static void main(String[] args) {
        SoftReference<MyObject> softReference = new SoftReference<>(new MyObject());
        System.out.println("-----softReference:"+softReference.get());

        System.gc();
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("-----gc after内存够用: "+softReference.get());

        try
        {
            byte[] bytes = new byte[20 * 1024 * 1024];//20MB对象
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("-----gc after内存不够: "+softReference.get());
        }
    }
}
