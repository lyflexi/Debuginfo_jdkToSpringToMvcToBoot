package org.lyflexi.strategyPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:01
 */
public interface PayStrategy {

    boolean pay(int money);//支付

    void queryBalance(String accountNo);//查询余额
}
