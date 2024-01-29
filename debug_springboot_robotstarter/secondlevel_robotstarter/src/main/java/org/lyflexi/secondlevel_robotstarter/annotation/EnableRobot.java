package org.lyflexi.secondlevel_robotstarter.annotation;

import org.lyflexi.secondlevel_robotstarter.RobotAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lfy
 * @Description
 * @create 2023-04-27 20:24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(RobotAutoConfiguration.class)
public @interface EnableRobot {


}
