package org.lyflexi.debug_springframework.aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ly
 * @Date: 2024/2/12 11:40
 */
@Configuration
@ComponentScan({"org.lyflexi.debug_springframework.aware","cn.hutool.extra.spring"})
public class AwareConfig {

    @Bean
    public DogBean dogBean(){
        return new DogBean();
    }

}
