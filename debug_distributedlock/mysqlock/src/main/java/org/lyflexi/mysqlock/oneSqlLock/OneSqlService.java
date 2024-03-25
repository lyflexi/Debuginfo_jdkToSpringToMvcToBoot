package org.lyflexi.mysqlock.oneSqlLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OneSqlService {

    @Autowired
    StockMapper stockMapper;

    @Transactional
    public void deduct(){
        stockMapper.updateStock(1001,1);
    }
}
