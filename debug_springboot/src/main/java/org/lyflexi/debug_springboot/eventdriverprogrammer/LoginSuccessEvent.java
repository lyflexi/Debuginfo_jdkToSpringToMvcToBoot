package org.lyflexi.debug_springboot.eventdriverprogrammer;

import org.springframework.context.ApplicationEvent;

/**
 * @author lfy
 * @Description  登录成功事件。所有事件都推荐继承 ApplicationEvent
 * @create 2023-04-24 18:51
 */
public class LoginSuccessEvent  extends ApplicationEvent {

    /**
     *
     * @param source  代表是谁登录成了
     */
    public LoginSuccessEvent(UserEntity source) {
        super(source);
    }
}
