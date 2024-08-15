package org.lyflexi.basic_jetcache.service;


import org.lyflexi.basic_jetcache.po.User;

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
