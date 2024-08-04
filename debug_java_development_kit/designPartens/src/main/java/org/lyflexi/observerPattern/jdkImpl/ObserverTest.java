package org.lyflexi.observerPattern.jdkImpl;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:48
 */

public class ObserverTest {
    public static void main(String[] args) {
        Zone zone = new Zone();
        Friends friends = new Friends();
        friends.setFriendName("张三丰");

        Trends trends = new Trends();
        trends.setNickName("张无忌");
        trends.setContent("祝太师傅长命百岁！");
        zone.addObserver(friends);
        zone.publishTrends(trends);
    }
}

