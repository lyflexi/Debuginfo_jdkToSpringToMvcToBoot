package org.lyflexi;


import org.lyflexi.spi.ISearch;

/**
 * @Author: ly
 * @Date: 2024/1/14 13:53
 */
public class FileSearch implements ISearch {


    @Override
    public String searchDoc(String keyword) {
        return "文件查找：" + keyword;
    }
}
