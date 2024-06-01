package org.lyflexi.debug_springboot.actuator.health;


import org.springframework.stereotype.Component;

/**
 * @author lfy
 * @Description
 * @create 2023-05-08 22:58
 */
@Component
public class MyHahaComponent {

    public  int check(){
        //业务代码判断这个组件是否该是存活状态
        return 1;
    }

}
