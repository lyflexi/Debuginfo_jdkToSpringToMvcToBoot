package org.lyflexi.basic_jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMethodCache(basePackages = "org.lyflexi.basic_jetcache")
@EnableCreateCacheAnnotation
@MapperScan(value = "org.lyflexi.basic_jetcache.mapper")
public class BasicJetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicJetcacheApplication.class, args);
    }

}
