package org.lyflexi.visitorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/22 14:47
 */
public interface CorporateSlave {
    void accept(CorporateSlaveVisitor visitor);
}
