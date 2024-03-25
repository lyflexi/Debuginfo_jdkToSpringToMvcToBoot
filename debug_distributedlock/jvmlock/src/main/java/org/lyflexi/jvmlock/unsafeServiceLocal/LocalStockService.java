package org.lyflexi.jvmlock.unsafeServiceLocal;

import org.lyflexi.jvmlock.pojo.Stock;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

@Service
//@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LocalStockService {

    private Stock stock = new Stock();

    private ReentrantLock lock = new ReentrantLock();



    public void deduct(){
//        lock.lock();
        try {
            stock.setStock(stock.getStock() - 1);
            System.out.println("库存余量：" + stock.getStock());
        } finally {
//            lock.unlock();
        }
    }
}
