package org.lyflexi.mysqlock.selectforUpdateLock;

import org.lyflexi.mysqlock.pojo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ly
 * @Date: 2024/3/25 23:44
 */
public class ForUpdateService {

    @Autowired
    StockMapper stockMapper;

    @Transactional//开启事务
    public void deduct(){
        //先加锁
        Stock stock = stockMapper.selectStockForUpdate(1001);
        if (stock!=null&&stock.getStock()>0){
            //不在sql里做stock-1操作，因此下面是无锁更新
            stock.setStock(stock.getStock()-1);
            stockMapper.updateStock(stock);
        }
    }
}
