package org.lyflexi.debug_basicjdk.valuePropagation;

/**
 * @Author: ly
 * @Date: 2024/4/1 10:30
 */
public class Main {
    public static void main(String[] args) {
        int number = 10;
        System.out.println("Before calling modifyValue: " + number);
        modifyValue(number);
        System.out.println("After calling modifyValue: " + number);

        StringBuilder stringBuilder = new StringBuilder("Hello");
        System.out.println("Before calling modifyReference: " + stringBuilder);
        modifyReference(stringBuilder);
        System.out.println("After calling modifyReference: " + stringBuilder);
    }

    public static void modifyValue(int num) {
        num = 20;
    }

    public static void modifyReference(StringBuilder strBuilder) {
        strBuilder.append(" World");
    }
}

