package org.lyflexi.stateMachinePattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 17:39
 */
public class OrderContext {
    AbstractOrderState waitPaid;
    AbstractOrderState waitDeliver;
    AbstractOrderState receiveGoods;

    AbstractOrderState currState;//当前状态

    //创建并维护所有的状态，并初始换当前状态currState
    public OrderContext() {
        this.waitPaid = new WaitPaidOrderState(this);
        this.waitDeliver = new WaitDeliverOrderState(this);
        this.receiveGoods = new ReceiveGoodsOrderState(this);
        currState = waitPaid;
    }


    /*持有currState引用*/
    void setState(AbstractOrderState state){
        this.currState = state;
    }

    /*持有currState引用*/
    public void payOrder(){
        currState.payOrder();
    }

    /*持有currState引用*/
    public void deliver(){
        currState.deliver();
    }

    public void receiveGoods(){
        currState.receiveGoods();
    }
}

