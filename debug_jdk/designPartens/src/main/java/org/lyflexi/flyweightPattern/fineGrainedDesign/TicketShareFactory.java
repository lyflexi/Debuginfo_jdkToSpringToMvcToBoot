package org.lyflexi.flyweightPattern.fineGrainedDesign;

/**
 * @Author: ly
 * @Date: 2024/4/11 11:17
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 享元对象工厂
 */
public class TicketShareFactory {
    private static Map<String,IShareTicket> CACHE_POOL = new HashMap<>();

    public static IShareTicket getTicketInfo(String from,String to){
        String key = from + "->" + to;
        if (TicketShareFactory.CACHE_POOL.containsKey(key)){
            System.out.println("使用缓存");
            return TicketShareFactory.CACHE_POOL.get(key);
        }
        System.out.println("未使用缓存");
        IShareTicket ticket = new TrainShareTicket(from,to);
        CACHE_POOL.put(key,ticket);
        return ticket;
    }
}

