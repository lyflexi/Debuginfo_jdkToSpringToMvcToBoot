package org.lyflexi.observerPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:46
 */
public interface Observer {
    void update(float temperature,float humidity,float pressure);
}
