package org.lyflexi.delegatePattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:17
 */

import java.util.HashMap;
import java.util.Map;

public class Manager implements IEmployee {
    private Map<String,IEmployee> workTargetMap = new HashMap<>();

    public Manager() {
        workTargetMap.put("部署项目",new EmployeeA());
        workTargetMap.put("修复BUG",new EmployeeB());
    }

    @Override
    public void work(String taskCommand) {
        IEmployee employee = workTargetMap.get(taskCommand);
        if(null == employee){
            System.out.println("未找到可以执行任务的员工");
            return;
        }
        employee.work(taskCommand);
    }
}

