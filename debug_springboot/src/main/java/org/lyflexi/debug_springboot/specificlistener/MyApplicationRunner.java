package org.lyflexi.debug_springboot.specificlistener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/1/29 21:10
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner...run...");
        System.out.println("MyApplicationRunner Arrays.asList(args):"+Arrays.asList(args));
        System.out.println("MyApplicationRunner args.getOptionNames():"+args.getOptionNames());
        System.out.println("MyApplicationRunner args.getOptionValues(\"name\"):"+args.getOptionValues("name"));
        System.out.println("MyApplicationRunner args.getOptionValues(\"email\"):"+args.getOptionValues("email"));
    }
}
