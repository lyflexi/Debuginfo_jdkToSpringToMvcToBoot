package org.lyflexi.flyweightPattern.fineGrainedDesign;

/**
 * @Author: ly
 * @Date: 2024/4/11 11:16
 */
/**
 * 抽象享元角色
 */
public interface IShareTicket {
    void info();
    void setSeat(String seatType);
}
