package org.lyflexi.stateMachinePattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 17:43
 */

public class TestState {
    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext();
        orderContext.payOrder();
        orderContext.deliver();
        orderContext.receiveGoods();
    }
}

