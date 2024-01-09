package org.lyflexi.debug_springboot.unsafebean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Author: ly
 * @Date: 2024/1/8 16:53
 */
@Configuration

public class MyConfig {
    @Bean
    @Scope(value = "prototype")
    public User user(){
        return new User();
    }
}
