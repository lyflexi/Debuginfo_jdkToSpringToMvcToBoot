package org.lyflexi.custom_rabbit_framework.biz.controller;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.lyflexi.custom_rabbit_framework.biz.event.DemoEvent;
import org.lyflexi.custom_rabbit_framework.commonapi.message.DemoMessageData;
import org.lyflexi.custom_rabbit_framework.commonapi.publisher.IEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/13 18:55
 */


@RestController
@RequestMapping("/mock")
@Slf4j
public class MockController {
    /**
     * rabbitmq异步发送
     */
    @Autowired
    @Qualifier("asyncRabbitEventPublisher")
    private IEventPublisher asyncRabbitEventPublisher;
    @GetMapping(value = "/asyncRabbitEventPublisher")
    public void asyncRabbitEventPublisher (@RequestParam String name) {
        log.info("testDemoRabbitEventPublisher测试开始");
        DemoMessageData message = new DemoMessageData();
        message.setId(RandomUtil.randomNumbers(10));
        message.setName("testDemoRabbitEventPublisher");
        message.setSeqNo(RandomUtil.randomNumbers(10));
        message.setVersion(RandomUtil.randomLong());
        message.setFactoryCode("SZ54");
        asyncRabbitEventPublisher.publish(DemoEvent.of(message));
        log.info("testDemoRabbitEventPublisher测试结束");
    }

    /**
     * rabbitmq同步发送
     */
    @Autowired
    @Qualifier("rabbitEventPublisher")
    private IEventPublisher rabbitEventPublisher;
    @GetMapping(value = "/rabbitEventPublisher")
    public void rabbitEventPublisher (@RequestParam String name) {
        log.info("rabbitEventPublisher测试开始");
        DemoMessageData message = new DemoMessageData();
        message.setId(RandomUtil.randomNumbers(10));
        message.setName("rabbitEventPublisher");
        message.setSeqNo(RandomUtil.randomNumbers(10));
        message.setVersion(RandomUtil.randomLong());
        message.setFactoryCode("SZ54");
        asyncRabbitEventPublisher.publish(DemoEvent.of(message));
        log.info("rabbitEventPublisher测试结束");
    }
}
