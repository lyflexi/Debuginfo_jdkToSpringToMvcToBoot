package org.lyflexi.debug_springframework.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class MyApplicationListenerByAnnoatation {

	@EventListener(classes={ApplicationEvent.class})
	public void listen(ApplicationEvent event){
		System.out.println("监听方式二：UserService的@EventListener注解监听到的事件："+event);
	}

}
