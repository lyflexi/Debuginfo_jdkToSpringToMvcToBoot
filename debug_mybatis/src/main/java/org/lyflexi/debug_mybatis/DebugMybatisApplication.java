package org.lyflexi.debug_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("org.lyflexi.debug_mybatis.dao")
@SpringBootApplication
public class DebugMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DebugMybatisApplication.class, args);
    }

}
