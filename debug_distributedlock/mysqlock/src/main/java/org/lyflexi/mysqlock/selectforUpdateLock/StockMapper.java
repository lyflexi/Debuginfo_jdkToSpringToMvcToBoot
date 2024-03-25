package org.lyflexi.mysqlock.selectforUpdateLock;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.lyflexi.mysqlock.pojo.Stock;
import org.springframework.stereotype.Repository;

/**
 * @Author: ly
 * @Date: 2024/3/25 21:36
 */
@Repository
public interface StockMapper {

    @Update(" select * from db_stock where id = #{id} for update")
    public Stock selectStockForUpdate(@Param("id") Integer id) ;
    @Update(" update db_stock set db_stock.stock = #{stock.stock} where db_stock.stock = #{stock.id}")
    public void updateStock(@Param("stock") Stock stock) ;
}

