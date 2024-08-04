package org.lyflexi.singletonPattern.enumerated;

/**
 * @Author: ly
 * @Date: 2024/3/13 20:36
 */
public class EnumSingletonTest {
    public static void main(String[] args) {
        // 获取单例实例
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;

        // 检查是否是同一个实例
        System.out.println("singleton1和singleton2是否相等：" + (singleton1 == singleton2)); // 输出 true
    }
}
