package org.lyflexi.feignorderclient.controller;

import org.lyflexi.cloudfeignapi.Result;
import org.lyflexi.cloudfeignapi.User;
import org.lyflexi.feignorderclient.feign.client.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/7/27 14:13
 */
//curl http://localhost:9000/consumer/feign/user/get/1
@RestController
public class UserClientController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/consumer/feign/user/get/{id}")
    public Result<User> getUserById(@PathVariable("id") Long id)
    {
        User user = userService.getUserById(id);
        return new Result<>(user);
    }
}