package org.lyflexi.firstlevel_robotstarter;


import org.lyflexi.firstlevel_robotstarter.controller.RobotController;
import org.lyflexi.firstlevel_robotstarter.properties.RobotProperties;
import org.lyflexi.firstlevel_robotstarter.service.RobotService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lfy
 * @Description
 * @create 2023-04-27 20:15
 */
//给容器中导入Robot功能要用的所有组件
@Import({RobotProperties.class, RobotService.class})
@Configuration
public class RobotAutoConfiguration {

    @Bean //把组件导入到容器中，与@Import效果一样
    public RobotController robotController(){
        return new RobotController();
    }


}
