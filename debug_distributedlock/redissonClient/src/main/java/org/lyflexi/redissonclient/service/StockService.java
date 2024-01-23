package org.lyflexi.redissonclient.service;


import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class StockService {

    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    RedissonClient redissonClient;
    public void deduct() {
        RLock lock = redissonClient.getLock("lock");
        lock.lock();

        try {
            // 1. 查询库存信息
            String stock = redisTemplate.opsForValue().get("stock").toString();

            // 2. 判断库存是否充足
            if (stock != null && stock.length() != 0) {
                Integer st = Integer.valueOf(stock);
                if (st > 0) {
                    // 3.扣减库存
                    redisTemplate.opsForValue().set("stock", String.valueOf(--st));
                }
            }

        } finally {
            lock.unlock();
        }
    }

}
