package org.lyflexi.stateMachinePattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 17:38
 */
public class WaitPaidOrderState extends AbstractOrderState {
    public WaitPaidOrderState(OrderContext orderContext) {
        super(orderContext);
    }

    @Override
    public void payOrder() {//相当于待支付的状态绑定了支付行为
        System.out.println("支付成功");
        //持有orderContext引用
        this.orderContext.setState(this.orderContext.waitDeliver);//切换状态
    }

    @Override
    public void deliver() {
        System.out.println("对不起，请先付钱");
    }

    @Override
    public void receiveGoods() {
        System.out.println("对不起，请先付钱");
    }
}
