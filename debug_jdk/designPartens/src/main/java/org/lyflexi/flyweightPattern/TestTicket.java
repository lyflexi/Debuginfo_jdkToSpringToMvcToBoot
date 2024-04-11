package org.lyflexi.flyweightPattern;

/**
 * @Author: ly
 * @Date: 2024/4/11 11:12
 */

public class TestTicket {
    public static void main(String[] args) {
        ITicket ticket = TicketFactory.getTicketInfo("深圳","广州");
        ticket.info();//首次创建对象
        ticket = TicketFactory.getTicketInfo("深圳","广州");
        ticket.info();//使用缓存
        ticket = TicketFactory.getTicketInfo("深圳","北京");
        ticket.info();//换了目的地，无法使用缓存
    }
}

