package org.lyflexi.mementoPattern;

import java.util.ArrayList;
import java.util.List; /**
 * @Author: ly
 * @Date: 2024/4/15 10:39
 */
public class ArticleCaretaker {
    private final List<ArticleMemento> list = new ArrayList<>();

    public ArticleMemento getArticle(int index){
        return list.get(index);
    }

    public void setArticle(ArticleMemento articleMemento){
        list.add(articleMemento);
    }
}
