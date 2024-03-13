package org.lyflexi.chainOfResponsibilityPattern.chain;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:31
 */

public abstract class MyHandler {
    protected MyHandler next;

    public void next(MyHandler handler){
        this.next = handler;
    }

    public abstract void doHandler(LoginUser loginUser);
}
