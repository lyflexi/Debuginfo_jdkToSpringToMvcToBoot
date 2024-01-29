package org.lyflexi.debug_springboot.specificlistener;

import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;

/**
 * @Author: ly
 * @Date: 2024/1/29 21:18
 */
public class MyBootstrapRegistryInitializer implements BootstrapRegistryInitializer {
    @Override
    public void initialize(BootstrapRegistry registry) {
        System.out.println("MyBootstrapRegistryInitializer ....initialize.... ");

    }
}
