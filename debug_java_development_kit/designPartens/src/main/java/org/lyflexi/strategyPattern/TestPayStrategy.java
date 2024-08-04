package org.lyflexi.strategyPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:03
 */

public class TestPayStrategy {
//    public static void main(String[] args) {
//        String pay = "aliPay";
//        PayStrategy payStrategy = null;
//        if(pay.equals("aliPay")){
//            payStrategy = new AliPayStrategy();
//        }else if(pay.equals("wechatPay")){
//            payStrategy = new WechatPayStrategy();
//        }
//        payStrategy.pay(10);
//        payStrategy.queryBalance("XXX");
//    }

    public static void main(String[] args) {
        String pay = "aliPay";
        PayStrategy payStrategy = PayEnum.getValue(pay);
        payStrategy.pay(10);
        payStrategy.queryBalance("XXX");
    }
}

