package org.lyflexi.stateMachinePattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 17:37
 */

public abstract class AbstractOrderState {
    protected OrderContext orderContext;

    public AbstractOrderState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    public abstract void payOrder();

    public abstract void deliver();

    public abstract void receiveGoods();
}

