package org.lyflexi.debug_springmvc.mvcintegration.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//Spring的容器不扫描controller;父容器
@ComponentScan(value="org.lyflexi.debug_springmvc.mvcintegration",excludeFilters={
		@Filter(type=FilterType.ANNOTATION,classes={Controller.class})
})
public class RootConfig {

}
