package org.lyflexi.debug_springframework.aware;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ly
 * @Date: 2024/2/12 17:42
 */

//当前的SomeServiceNonSpring是非Spring管理的类，无法使用@Autowired注入所需要的组件，怎么办？
//现成的解决方案是：通过hutool提供的SpringUtil.getBean方法获取


public class SomeServiceNonSpring {

    public static void main(String[] args) {
        //只是向Spring容器中注入配置类AwareConfig.class，让配置类生效
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(AwareConfig.class);

        //可以看到我们并没有通过applicationContext来获取Bean，而是通过SpringUtil来获取Bean
        DogBean bean1 = SpringUtil.getBean(DogBean.class);
        System.out.println(bean1);

        //使用我们自己手写的MySpringUtil.getBeanByApplicationContextAware
        DogBean bean2 = MySpringUtil.getBeanByApplicationContextAware(DogBean.class);
        System.out.println(bean2);
        //使用我们自己手写的MySpringUtil.getBeanByApplicationContextAware
        DogBean bean3 = MySpringUtil.getBeanByBeanFactoryAware(DogBean.class);
        System.out.println(bean3);
    }
}
