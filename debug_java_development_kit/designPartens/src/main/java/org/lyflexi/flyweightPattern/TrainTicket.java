package org.lyflexi.flyweightPattern;

/**
 * @Author: ly
 * @Date: 2024/4/11 11:11
 */

/**
 * 具体享元角色(粗粒度)
 */
public class TrainTicket implements ITicket{
    private String from;
    private String to;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void info() {
        System.out.println(from + "->" + to + ":硬座：100元，硬卧：200元");
    }
}
