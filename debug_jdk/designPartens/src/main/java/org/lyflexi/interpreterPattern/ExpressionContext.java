package org.lyflexi.interpreterPattern;

/**
 * @Author: ly
 * @Date: 2024/4/15 10:24
 */

import java.util.Stack;

public class ExpressionContext {
    private Integer currValue;//记录当前运算结果，空表示暂未运算
    private Stack<IExpression> stack = new Stack<>();

    public ExpressionContext(String expression) {
        this.parse(expression);
    }

    private void parse(String expression) {
        String[] elementArr = expression.split(" ");
        for (int i=0;i<elementArr.length;i++){
            String element = elementArr[i];
            if (element.equals("+")){
                IExpression leftExpression = stack.pop();//栈内元素出栈
                IExpression rightExpression = new NumberExpression(elementArr[++i]);//取出+号后的下一个元素
                IExpression addExpression = new AddExpression(leftExpression,rightExpression);
                stack.push(new NumberExpression(addExpression.interpret() + ""));//将计算结果入栈
            }else if (element.equals("-")){
                IExpression leftExpression = stack.pop();//栈内元素出栈
                IExpression rightExpression = new NumberExpression(elementArr[++i]);//取出-号后的下一个元素
                IExpression subExpression = new SubExpression(leftExpression,rightExpression);
                stack.push(new NumberExpression(subExpression.interpret() + ""));//将计算结果入栈
            }else{
                stack.push(new NumberExpression(element));//如果是数字则直接入栈
            }
        }
    }

    public int calcuate(){
        return stack.pop().interpret();//经过前面解析，到这里stack内只会剩下唯一一个数字，即运算结果
    }
}

