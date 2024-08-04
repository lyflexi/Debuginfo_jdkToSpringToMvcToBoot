package org.lyflexi.strategyPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:03
 */
public class WechatPayStrategy implements PayStrategy {
    @Override
    public boolean pay(int money) {
        System.out.println("微信支付成功");
        return true;
    }
    @Override
    public void queryBalance(String accountNo) {
        System.out.println("微信余额10元");
    }
}

