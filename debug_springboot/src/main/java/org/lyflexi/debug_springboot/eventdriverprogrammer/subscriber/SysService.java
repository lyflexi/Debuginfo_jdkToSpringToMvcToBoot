package org.lyflexi.debug_springboot.eventdriverprogrammer.subscriber;


import org.lyflexi.debug_springboot.eventdriverprogrammer.LoginSuccessEvent;
import org.lyflexi.debug_springboot.eventdriverprogrammer.UserEntity;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author lfy
 * @Description
 * @create 2023-04-24 18:44
 */
@Service
public class SysService {

    @EventListener
    public void haha(LoginSuccessEvent event){
        System.out.println("==== SysService ===感知到事件"+event);
        UserEntity source = (UserEntity) event.getSource();
        recordLog(source.getUsername());
    }

    public void recordLog(String username){
        System.out.println(username + "登录信息已被记录");
    }
}
