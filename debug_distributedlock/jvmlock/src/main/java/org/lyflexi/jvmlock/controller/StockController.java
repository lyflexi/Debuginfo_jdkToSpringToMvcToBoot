package org.lyflexi.jvmlock.controller;

import org.lyflexi.jvmlock.unsafeServiceLocal.LocalStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    private LocalStockService localStockService;

    @GetMapping("stock/deduct")
    public String deduct(){
        this.localStockService.deduct();
        return "hello stock deduct！！";
    }

}

