package org.lyflexi.jvmlock.pojo;

import lombok.Data;

@Data
public class Stock {
    private Integer productCode;

    private Integer stock = 5000;
}
