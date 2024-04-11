package org.lyflexi.flyweightPattern;

/**
 * @Author: ly
 * @Date: 2024/4/11 17:25
 */
public class TestInteger {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(10);
        Integer b = 10;
        System.out.println(a==b);

        Integer m = Integer.valueOf(128);
        Integer n = 128;
        System.out.println(m==n);
    }
}
