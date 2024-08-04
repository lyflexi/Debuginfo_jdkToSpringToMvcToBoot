package org.lyflexi.chainOfResponsibilityPattern.chain;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:33
 */

public class VerifyRoleHanlder extends MyHandler {
    @Override
    public void doHandler(LoginUser loginUser) {
        if(!"admin".equals(loginUser.getRoleName())){
            System.out.println("角色信息有误");
            return;
        }
        System.out.println("角色信息校验通过");

        next.doHandler(loginUser);
    }
}

