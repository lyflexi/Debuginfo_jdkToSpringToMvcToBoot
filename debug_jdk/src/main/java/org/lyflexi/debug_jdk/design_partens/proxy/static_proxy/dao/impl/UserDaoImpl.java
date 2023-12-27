package org.lyflexi.debug_jdk.design_partens.proxy.static_proxy.dao.impl;


import org.lyflexi.debug_jdk.design_partens.proxy.static_proxy.dao.IUserDao;

public class UserDaoImpl implements IUserDao {

    public int delete(int id) {
        System.out.println("正常实现, 删除用户操作");
        return 0;
    }
}
