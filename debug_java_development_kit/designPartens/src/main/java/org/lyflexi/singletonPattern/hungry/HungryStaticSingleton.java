package org.lyflexi.singletonPattern.hungry;

/**
 * @Author: ly
 * @Date: 2024/3/13 20:16
 */

public class HungryStaticSingleton {
    private static final HungryStaticSingleton hungrySigleton;
    static {
        hungrySigleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {
    }

    public static HungryStaticSingleton getInstance(){
        return hungrySigleton;
    }
}

