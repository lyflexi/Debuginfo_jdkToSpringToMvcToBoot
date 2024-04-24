package org.lyflexi.mementoPattern;

/**
 * @Author: ly
 * @Date: 2024/4/15 10:39
 */

import java.util.Date;

public class ArticleMemento {
    private String title;
    private String content;
    private Date createTime;

    public ArticleMemento(String title, String content, Date createTime) {
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

