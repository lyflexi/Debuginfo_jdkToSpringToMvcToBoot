package org.lyflexi.jvmlock.unsafeServiceMySql;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.ReentrantLock;

@Service
public class MySqlStockService {

    @Autowired
    StockMapper stockMapper;

    private ReentrantLock lock = new ReentrantLock();


    @Transactional
    public void deduct(){
        lock.lock();
        try {
            Stock stock = stockMapper.selectOne(1001);
            if (stock!=null&&stock.getStock()>0){
                stock.setStock(stock.getStock()-1);
                stockMapper.updateStock(stock);
            }
        } finally {
            lock.unlock();
        }
    }
}
