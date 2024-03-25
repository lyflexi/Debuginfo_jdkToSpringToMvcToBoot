package org.lyflexi.mysqlock.oneSqlLock;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @Author: ly
 * @Date: 2024/3/25 21:36
 */
@Repository
public interface StockMapper {

    @Update(" update db_stock set count = count - {#count} where product_code = #{#productCode} and count>={#count}")
    public void updateStock(@Param("productCode") Integer productCode,@Param("count") Integer count);
}



