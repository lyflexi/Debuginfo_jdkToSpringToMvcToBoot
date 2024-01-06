package org.lyflexi.debug_springframework.listener;

import org.junit.jupiter.api.Test;
import org.lyflexi.debug_springframework.beanfactorylifecircle.ExtConfig;
import org.lyflexi.debug_springframework.tx.TxConfig;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ly
 * @Date: 2024/1/6 20:18
 */
public class ListenerTest {

    /*
    * 有参构造AnnotationConfigApplicationContext(ConfigListener.class)
    * */
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigListener.class);
//配置类ConfigListener添加了包扫描，因此无需再手动注册listener
//        applicationContext.addApplicationListener(new MyApplicationListener());
//        applicationContext.register(MyApplicationListenerByAnnoatation.class);
//有参构造AnnotationConfigApplicationContext中已经调用了refresh()，因此不可再次手动调用refresh()，refresh()只能调用一次
/*        	public AnnotationConfigApplicationContext(Class<?>... componentClasses) {
            this();
            register(componentClasses);
            refresh();
        }*/
//        applicationContext.refresh();
        //发布事件
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
        });

        applicationContext.close();
    }

    /*
     * 无参构造AnnotationConfigApplicationContext()
     * */
    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.addApplicationListener(new MyApplicationListener());
        applicationContext.register(MyApplicationListenerByAnnoatation.class);

        applicationContext.refresh();
        //发布事件
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
        });

        applicationContext.close();
    }
}
