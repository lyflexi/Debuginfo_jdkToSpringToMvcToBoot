package org.lylfexi.debug_jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMethodCache(basePackages = "org.lylfexi.debug_jetcache")
@EnableCreateCacheAnnotation
@MapperScan(value = "org.lylfexi.debug_jetcache.simpletest.mapper")
public class DebugJetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(DebugJetcacheApplication.class, args);
    }

}
