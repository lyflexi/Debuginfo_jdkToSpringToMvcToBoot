package org.lyflexi.debug_springboot.specificlistener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: ly
 * @Date: 2024/1/29 21:12
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner....run....");
    }
}
