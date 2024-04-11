package org.lyflexi.flyweightPattern;

/**
 * @Author: ly
 * @Date: 2024/4/11 11:12
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 享元对象工厂
 */
public class TicketFactory {
    private static Map<String,ITicket> CACHE_POOL = new HashMap<>();

    public static ITicket getTicketInfo(String from,String to){
        String key = from + "->" + to;
        if (TicketFactory.CACHE_POOL.containsKey(key)){
            System.out.println("使用缓存");
            return TicketFactory.CACHE_POOL.get(key);
        }
        System.out.println("未使用缓存");
        ITicket ticket = new TrainTicket(from,to);
        CACHE_POOL.put(key,ticket);
        return ticket;
    }
}

