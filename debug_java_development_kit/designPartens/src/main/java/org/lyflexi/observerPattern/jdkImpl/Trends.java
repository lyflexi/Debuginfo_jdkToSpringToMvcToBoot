package org.lyflexi.observerPattern.jdkImpl;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:48
 */

public class Trends {
    private String nickName;//发表动态的用户昵称
    private String content;//发表的动态内容

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

