package org.lyflexi.mementoPattern;

/**
 * @Author: ly
 * @Date: 2024/4/15 10:40
 */

import java.util.Date;

public class TestMemento {
    public static void main(String[] args) {
        ArticleCaretaker articleCaretaker = new ArticleCaretaker();

        ArticleText articleText = new ArticleText("标题1","内容1",new Date());
        ArticleMemento articleMemento = articleText.saveToMemento();
        articleCaretaker.setArticle(articleMemento);//备忘1次

        articleText = new ArticleText("标题2","内容2",new Date());
        System.out.println(String.format("修改后的标题为【%s】，内容为【%s】",articleText.getTitle(),articleText.getContent()));

        articleText.getArticleFromMemento(articleCaretaker.getArticle(0));
        System.out.println(String.format("还原后的标题为【%s】，内容为【%s】",articleText.getTitle(),articleText.getContent()));
    }
}

