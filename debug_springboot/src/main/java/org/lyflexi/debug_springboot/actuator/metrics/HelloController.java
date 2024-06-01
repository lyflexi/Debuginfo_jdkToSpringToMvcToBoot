package org.lyflexi.debug_springboot.actuator.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lfy
 * @Description
 * @create 2023-05-08 23:07
 */
@RestController
public class HelloController {

    @Autowired
    MyLaLaComponent myLaLaComponent;

    @GetMapping("/hello")
    public String hello(){
        //业务调用
        myLaLaComponent.hello();
        return "哈哈哈";
    }
}
