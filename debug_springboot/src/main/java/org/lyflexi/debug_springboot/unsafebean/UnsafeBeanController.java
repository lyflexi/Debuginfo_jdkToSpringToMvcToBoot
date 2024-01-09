package org.lyflexi.debug_springboot.unsafebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ly
 * @Date: 2024/1/8 16:52
 */
@RestController
@Scope(value = "prototype") // prototype singleton
public class UnsafeBeanController {
    private int var = 0; // 定义一个普通变量

    private static int staticVar = 0; // 定义一个静态变量

    @Value("${test-int}")
    private int testInt; // 从配置文件中读取变量

    ThreadLocal<Integer> tl = new ThreadLocal<>(); // 用ThreadLocal来封装变量

    @Autowired
    private User user; // 注入一个对象来封装变量


    @GetMapping(value = "/test_var")
    public String test() {

        System.out.println("Before"+"普通变量var:" + var + "===静态变量staticVar:" + staticVar + "===配置变量testInt:" + testInt
                + "===ThreadLocal变量tl:" + tl.get() + "===注入变量user:" + user.getAge());
        tl.set(1);
        user.setAge(1);
        ++var;
        ++staticVar;
        ++testInt;


        System.out.println("After"+"普通变量var:" + var + "===静态变量staticVar:" + staticVar + "===配置变量testInt:" + testInt
                + "===ThreadLocal变量tl:" + tl.get() + "===注入变量user:" + user.getAge());



        return null;
    }
}
