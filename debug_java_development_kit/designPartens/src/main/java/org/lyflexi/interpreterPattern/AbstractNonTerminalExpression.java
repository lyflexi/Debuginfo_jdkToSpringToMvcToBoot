package org.lyflexi.interpreterPattern;

/**
 * @Author: ly
 * @Date: 2024/4/15 10:22
 */

/*非终结符解释器的代码复用模板*/
public abstract class AbstractNonTerminalExpression implements IExpression{
    protected IExpression leftExpression;
    protected IExpression rightExpression;

    public AbstractNonTerminalExpression(IExpression leftExpression, IExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
}

