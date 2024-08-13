package org.lyflexi.custom_rabbit_framework.commonapi.event;

import org.lyflexi.custom_rabbit_framework.commonapi.message.IMessageData;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/13 13:52
 */
public interface IEvent {

    String EVENT_TARGET_LOCAL = "local";
    String EVENT_TARGET_CORE = "les-core";

    /**
     * 获取时间类型，里面会包含topic、队列、路由、及交换机信息
     * 后续对接MQ扩展
     */
    String getEventType ();

    /**
     * 获取事件发送目标
     */
    String getTarget ();

    /**
     * 获取消息
     */
    IMessageData getMessageData();
}
