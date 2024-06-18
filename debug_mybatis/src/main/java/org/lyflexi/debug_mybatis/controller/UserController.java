package org.lyflexi.debug_mybatis.controller;

import org.lyflexi.debug_mybatis.entity.UserParam;
import org.lyflexi.debug_mybatis.entity.UserPo;
import org.lyflexi.debug_mybatis.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ly
 * @Date: 2024/6/18 21:56
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping(path = "/get/{userId}",method = RequestMethod.GET)
    public UserPo getUser(@PathVariable Long userId)
    {
        return  userService.getById(userId);
    }

    @RequestMapping(path = "/update",method = RequestMethod.PUT)
    public Boolean updateUser(@RequestBody UserParam param)
    {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(param,userPo);
        return userService.updateById(userPo);
    }

    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public void addUser(@RequestBody UserParam param)
    {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(param,userPo);
        userService.save(userPo);
    }


}
