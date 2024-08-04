package org.lyflexi.chainOfResponsibilityPattern.chainHasBuilder;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:54
 */

public class TestBuildChain {
    public static void main(String[] args) {
        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName("孤狼1号");
        loginUser.setPassword("123456");
        loginUser.setRoleName("admin");
        loginUser.setPermission("admin");

        BuildHandler.Builder builder = new BuildHandler.Builder();
        builder.addHanlder(new VerifyAccountHandler())
                .addHanlder(new VerifyRoleHanlder())
                .addHanlder(new VerifyPermissionHanlder());
        builder.build().doHandler(loginUser);
    }
}
