package org.lyflexi.observerPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:45
 */
public interface Subject {
    void registerObserver(Observer o);//注册观察对象
    void removeObserver(Observer o);//移除观察对象
    void notifyObservers();//通知观察对象
}
