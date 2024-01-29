package org.lyflexi.debug_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(RobotAutoConfiguration.class)
//@EnableRobot
@SpringBootApplication

public class DebugSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DebugSpringbootApplication.class, args);
    }

}
