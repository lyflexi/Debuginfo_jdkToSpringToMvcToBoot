package org.lyflexi.debug_basicjdk.reference;

/**
 * @Author: ly
 * @Date: 2024/2/24 10:27
 */
public class MyObject
{
    //这个方法一般不用复写，我们只是为了教学给大家演示案例做说明
    @Override
    protected void finalize() throws Throwable
    {
        // finalize的通常目的是在对象被不可撤销地丢弃之前执行清理操作。
        System.out.println("-------invoke finalize method~!!!");
    }
}


