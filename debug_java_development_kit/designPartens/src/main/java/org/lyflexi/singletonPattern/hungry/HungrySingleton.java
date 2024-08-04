package org.lyflexi.singletonPattern.hungry;

/**
 * @Author: ly
 * @Date: 2024/3/13 20:16
 */

public class HungrySingleton {
    private static final HungrySingleton hungrySigleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance(){
        return hungrySigleton;
    }
}