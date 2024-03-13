package org.lyflexi.observerPattern.jdkImpl;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:47
 */


import java.util.Observable;

public class Zone extends Observable {
    public void publishTrends(Trends trends){
        System.out.println(trends.getNickName() + "发表了一个动态【" + trends.getContent() + "】" );
        setChanged();//仅作标识用
        notifyObservers(trends);//通知所有观察者
    }
}

