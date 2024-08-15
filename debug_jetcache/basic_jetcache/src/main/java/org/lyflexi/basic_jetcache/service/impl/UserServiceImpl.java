package org.lyflexi.basic_jetcache.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.Cached;
import com.alicp.jetcache.anno.CreateCache;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;

import org.lyflexi.basic_jetcache.mapper.UserMapper;
import org.lyflexi.basic_jetcache.po.User;
import org.lyflexi.basic_jetcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ly
 * @Date: 2024/6/1 18:33
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    UserMapper userMapper;
    @CreateCache(name = "userCacheVariable",expire = 100)
    private Cache<String, User> userCache;
    @Override
    public void cacheHandler() {
        //创建缓存并使用，使用方式和map一样
        User user = new User();
        user.setId(1L);
        user.setName("badao");
        user.setAge(18);

        userCache.put("key",user);
        System.out.println(userCache);
        System.out.println(userCache.get("key"));
        //userCache.remove(1l);
    }

    @Override
    @Cached(name = "userCacheMethod",expire = 3600)
    public List<User> getDbALLUser() {
        log.info("缓存过期：userCacheMethod");
        return userMapper.selectList(new QueryWrapper<>());
    }

    @Cached(name = "userCacheMethodRefresh",expire = 3600)
    @CacheRefresh(timeUnit = TimeUnit.SECONDS,refresh = 10)
    @Override
    public List<User> userCacheMethodRefresh(){
        return userMapper.selectList(new QueryWrapper<>());
    }

}
