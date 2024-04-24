package org.lyflexi.interpreterPattern;

/**
 * @Author: ly
 * @Date: 2024/4/15 10:24
 */

public class TestInterpreter {
    public static void main(String[] args) {
        ExpressionContext context = new ExpressionContext("666 + 888 - 777");
        System.out.println(context.calcuate());
        context = new ExpressionContext("123 - 456 + 11");
        System.out.println(context.calcuate());

    }
}

