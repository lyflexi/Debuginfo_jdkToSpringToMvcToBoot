package org.lyflexi.debug_basicjdk;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DebugBasicjdkApplication {


    public static void main(String[] args) {
        SpringApplication.run(DebugBasicjdkApplication.class, args);
        log.info("Hello World!");
    }

}
