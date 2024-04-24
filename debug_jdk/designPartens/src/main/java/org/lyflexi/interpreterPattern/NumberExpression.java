package org.lyflexi.interpreterPattern;

/**
 * @Author: ly
 * @Date: 2024/4/15 10:24
 */

/**
 * 终结表达式-数值表达式
 */
public class NumberExpression implements IExpression{
    private int value;

    public NumberExpression(String value) {
        this.value = Integer.valueOf(value);
    }

    @Override
    public int interpret() {
        return this.value;
    }
}

