package org.lyflexi.custom_rabbit_framework.biz.listener;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.lyflexi.custom_rabbit_framework.biz.event.DemoEvent;
import org.lyflexi.custom_rabbit_framework.biz.handler.DemoMessageHandler;
import org.lyflexi.custom_rabbit_framework.commonapi.constant.MQIConstant;
import org.lyflexi.custom_rabbit_framework.commonapi.listener.IListener;
import org.lyflexi.custom_rabbit_framework.commonapi.message.DemoMessageData;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/13 15:46
 */

@Slf4j
@Component
public class DemoEventListener implements IListener {

    @Autowired
    private DemoMessageHandler demoMessageHandler;

    /**
     * 监听RabbitMQ消息
     * @param message 消息对象
     * @param deliveryTag MQ消息唯一标识
     * @param channel MQ通道
     */
    @RabbitListener(queues = MQIConstant.TASK_SUBMITTED_QUEUE, concurrency = "1")
    public void onRabbitMQEvent(DemoMessageData message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) {
        demoMessageHandler.handleMessage(message);
    }

    /**
     * 监听Spring事件消息
     * @param event 事件对象
     */
    @Async
    @EventListener
    public void onSpringEvent(DemoEvent event) {
        log.info("[Demo-Listener]接收到事件：{}", JSON.toJSONString(event));
        demoMessageHandler.handleMessage(event.getMessageData());
    }
}