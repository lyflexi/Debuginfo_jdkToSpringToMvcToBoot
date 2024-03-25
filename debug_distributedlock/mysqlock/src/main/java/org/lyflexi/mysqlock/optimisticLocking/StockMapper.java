package org.lyflexi.mysqlock.optimisticLocking;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import org.springframework.stereotype.Repository;

/**
 * @Author: ly
 * @Date: 2024/3/25 21:36
 */
@Repository
public interface StockMapper {

    @Update(" select * from db_stock where id = #{id}")
    public Stock selectById(@Param("id") Long id) ;
    @Update(" update db_stock set db_stock.stock = #{stock.stock} where db_stock.stock = #{stock.id} and db_stock.versoin = #{stock.version}")
    public int updateStock(@Param("stock") Stock stock) ;
}

