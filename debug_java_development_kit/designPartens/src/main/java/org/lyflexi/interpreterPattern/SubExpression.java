package org.lyflexi.interpreterPattern;

/**
 * @Author: ly
 * @Date: 2024/4/15 10:24
 */

/**
 * 非终结表达式-具体表达式-减法表达式
 */
public class SubExpression extends AbstractNonTerminalExpression {

    public SubExpression(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int interpret() {
        return this.leftExpression.interpret() - this.rightExpression.interpret();
    }
}

