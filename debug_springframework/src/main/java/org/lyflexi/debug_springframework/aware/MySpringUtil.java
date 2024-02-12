package org.lyflexi.debug_springframework.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: ly
 * @Date: 2024/2/12 11:35
 */

@Component
public class MySpringUtil implements ApplicationContextAware, BeanFactoryAware {

    private static BeanFactory beanFactory;//供Spring内部使用的IOC容器

    private static ApplicationContext applicationContext;//供Spring外部用户们使用的IOC容器

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        MySpringUtil.beanFactory = beanFactory;

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MySpringUtil.applicationContext = applicationContext;
    }

    public static <T> T getBeanByApplicationContextAware(Class<T> clazz) {
        return MySpringUtil.applicationContext.getBean(clazz);
    }

    public static <T> T getBeanByBeanFactoryAware(Class<T> clazz) {
        return MySpringUtil.beanFactory.getBean(clazz);
    }


}
