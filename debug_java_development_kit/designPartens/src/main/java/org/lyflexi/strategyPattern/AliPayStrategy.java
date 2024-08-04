package org.lyflexi.strategyPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:01
 */
public class AliPayStrategy implements PayStrategy {
    @Override
    public boolean pay(int money) {
        System.out.println("支付宝支付成功");
        return true;
    }

    @Override
    public void queryBalance(String accountNo) {
        System.out.println("支付宝余额10元");
    }
}
