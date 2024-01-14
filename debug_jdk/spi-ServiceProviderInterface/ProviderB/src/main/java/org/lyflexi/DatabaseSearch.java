package org.lyflexi;
import org.lyflexi.spi.ISearch;
/**
 * @Author: ly
 * @Date: 2024/1/14 15:40
 */
public class DatabaseSearch implements ISearch {
    @Override
    public String searchDoc(String keyword) {
        return "数据库查找：" + keyword;
    }
}
