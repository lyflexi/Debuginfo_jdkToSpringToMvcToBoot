package org.lyflexi.mysqlock.optimisticLocking;

import lombok.Data;

@Data
public class Stock {
    private Integer productCode;
    private Long version ;
    private Integer count;

}
