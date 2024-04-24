package org.lyflexi.stateMachinePattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 17:38
 */

public class ReceiveGoodsOrderState extends AbstractOrderState{
    public ReceiveGoodsOrderState(OrderContext orderContext) {
        super(orderContext);
    }

    @Override
    public void payOrder() {
        System.out.println("您已经付过钱啦，不要重复付钱哦");
    }

    @Override
    public void deliver() {
        System.out.println("商品已发货并送达，请不要重复发货");
    }

    @Override
    public void receiveGoods() {
        System.out.println("用户已收到商品，此次交易结束");
    }
}

