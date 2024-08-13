package org.lyflexi.custom_rabbit_framework.commonapi.constant;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/13 14:49
 */

public class MQIConstant {

    /**
     * 默认交换机名称
     */
    public static final String LES_DEFAULT_TOPIC_EXCHANGE = "LES_DEFAULT_TOPIC_EXCHANGE";

    /**
     * 默认路由key
     */
    public static final String LES_DEFAULT_ROUTING_KEY = "LES_DEFAULT_ROUTING";
    /**
     * LES接收MES过站消息队列名称
     */
    public static final String MES2LES_PASS_STATION_QUEUE = "MES2LES_PASS_STATION_QUEUE";
    /**
     * LES任务下发消息队列名称
     */
    public static final String TASK_SUBMITTED_QUEUE = "TASK_SUBMITTED_QUEUE2";

    /**
     * Redis的key前缀
     */
    public static final String QUEUE_PREFIX = "queue";

    public static final String COUNTER_KEY = "counter";

    public static final String RCS_CONFIG_KEY = "rcs_ip_address";

    /*
     * */
    public static final String X_TENANT_ID = "x-tenant-id";


    public static final String RCS_TASK_ARRIVED_QUEUE = "RCS_TASK_ARRIVED_QUEUE";
    public static final String RCS_TASK_ACTION_EVENT = "RCS_TASK_ACTION_EVENT";






}

