package org.lyflexi.basic_jetcache;


import org.lyflexi.basic_jetcache.po.User;
import org.lyflexi.basic_jetcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/6/1 18:37
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(path = "/cacheHandler",method = RequestMethod.GET)
    public void cacheHandler()
    {
        userService.cacheHandler();
    }

    @RequestMapping(path = "/getDbALLUser",method = RequestMethod.GET)
    public List<User> getDbALLUser()
    {
        return userService.getDbALLUser();
        // 1. 获取缓存
        // 2. 缓存不存在，调用业务方法
        // 3. 缓存存在，返回缓存
    }

    @RequestMapping(path = "/getDbALLUserRefresh",method = RequestMethod.GET)
    public List<User> userCacheMethodRefresh()
    {
        return userService.userCacheMethodRefresh();
        // 1. 获取缓存
        // 2. 缓存不存在，调用业务方法
        // 3. 缓存存在，返回缓存
    }

}
