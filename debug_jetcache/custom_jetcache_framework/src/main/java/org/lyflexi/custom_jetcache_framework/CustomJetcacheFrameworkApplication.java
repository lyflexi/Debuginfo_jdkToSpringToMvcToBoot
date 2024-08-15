package org.lyflexi.custom_jetcache_framework;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMethodCache(basePackages = "org.lyflexi.custom_jetcache_framework")
@EnableCreateCacheAnnotation
public class CustomJetcacheFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomJetcacheFrameworkApplication.class, args);
    }

}
