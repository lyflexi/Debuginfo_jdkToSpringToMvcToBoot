package org.lyflexi.strategyPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:04
 */

public enum PayEnum {
    AliPay("aliPay",new AliPayStrategy()),
    WechatPay("wechatPay",new WechatPayStrategy());

    private String key;
    private PayStrategy value;

    PayEnum(String key, PayStrategy value) {
        this.key = key;
        this.value = value;
    }
    public static PayStrategy getValue(String key){
        for (PayEnum payEnum : PayEnum.values()){
            if (payEnum.key.equals(key)){
                return payEnum.value;
            }
        }
        return new AliPayStrategy();//没有合适key则默认阿里支付
    }
}

