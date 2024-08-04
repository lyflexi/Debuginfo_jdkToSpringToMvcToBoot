package org.lyflexi.spi;

/**
 * @Author: ly
 * @Date: 2024/1/14 16:43
 */
import java.util.ServiceLoader;

public class SearchDoc {

    public static void main(String[] args) {
        new SearchDoc().searchDocByKeyWord("hello world");
    }

    public void searchDocByKeyWord(String keyWord) {

        ServiceLoader<ISearch> searchServiceLoader = ServiceLoader.load(ISearch.class);

        for (ISearch search : searchServiceLoader){
            String doc = search.searchDoc(keyWord);
            System.out.println(doc);
        }
    }
}
