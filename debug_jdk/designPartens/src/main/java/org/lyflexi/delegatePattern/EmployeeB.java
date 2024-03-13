package org.lyflexi.delegatePattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:17
 */
public class EmployeeB implements IEmployee {
    @Override
    public void work(String taskCommand) {
        System.out.println("我是员工B，我正在工作:" + taskCommand);
    }
}

