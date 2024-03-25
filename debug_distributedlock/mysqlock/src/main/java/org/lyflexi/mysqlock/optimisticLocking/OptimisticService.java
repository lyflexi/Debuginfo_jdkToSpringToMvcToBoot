package org.lyflexi.mysqlock.optimisticLocking;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ly
 * @Date: 2024/3/25 23:44
 */
public class OptimisticService {

    @Autowired
    StockMapper stockMapper;


    public void checkAndLock() {

        // 先查询库存是否充足
        Stock stock = this.stockMapper.selectById(1L);

        // 再减库存
        if (stock != null && stock.getCount() > 0){
            // 获取版本号
            Long version = stock.getVersion();

            stock.setCount(stock.getCount() - 1);
            // 每次更新 版本号 + 1
            stock.setVersion(stock.getVersion() + 1);
            // 更新之前先判断是否是之前查询的那个版本，如果不是重试
            if (this.stockMapper.updateStock(stock)==0) {//返回0表示cas失败
                checkAndLock();
            }
        }
    }
}
