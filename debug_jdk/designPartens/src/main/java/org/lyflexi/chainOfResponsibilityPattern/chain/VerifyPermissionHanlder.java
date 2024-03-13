package org.lyflexi.chainOfResponsibilityPattern.chain;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:50
 */

public class VerifyPermissionHanlder extends MyHandler {
    @Override
    public void doHandler(LoginUser loginUser) {
        if (!"admin".equals(loginUser.getPermission())){
            System.out.println("暂无权限");
            return;
        }
        System.out.println("权限校验通过，登录成功");
    }
}

