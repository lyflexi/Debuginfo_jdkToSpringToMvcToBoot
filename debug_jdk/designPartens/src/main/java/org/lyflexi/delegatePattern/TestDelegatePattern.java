package org.lyflexi.delegatePattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:18
 */
public class TestDelegatePattern {

    public static void main(String[] args) {
        new Boss().startWork("部署项目",new Manager());
    }
}
