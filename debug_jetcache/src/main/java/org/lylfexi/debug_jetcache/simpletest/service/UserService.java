package org.lylfexi.debug_jetcache.simpletest.service;

import org.lylfexi.debug_jetcache.simpletest.po.User;

import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/6/1 18:33
 */
public interface UserService<T, R> {

    public void cacheHandler() ;

    public List<User> getDbALLUser();

    public List<User> userCacheMethodRefresh();
}
