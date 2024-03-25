package org.lyflexi.jvmlock.unsafeServiceMySql;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @Author: ly
 * @Date: 2024/3/25 21:36
 */
@Repository
public interface StockMapper {
    @Select(" select * from stock where product_code=#{productCode}")
    public Stock selectOne(@Param("productCode")Integer productCode);
    @Update(" update db_stock set db_stock.stock = #{stock.stock}")
    public void updateStock(@Param("stock") Stock stock) ;
}



