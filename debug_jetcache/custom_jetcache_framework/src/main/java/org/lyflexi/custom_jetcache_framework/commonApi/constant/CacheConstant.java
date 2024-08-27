package org.lyflexi.custom_jetcache_framework.commonApi.constant;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/15 13:21
 */

public class CacheConstant {

    /**
     * 缓存默认过期时间，2小时
     */
    public static final int CACHE_EXPIRE = 7200;
    /**
     * 字典缓存
     */
    public static final String CACHE_NAME_DICT = "SYS:dict";
    /**
     * 配置参数缓存
     */
    public static final String CACHE_NAME_SETTING = "SYS:setting";
    /**
     * 用户缓存
     */
    public static final String CACHE_NAME_USER = "USER:user";
    /**
     * 租户工厂缓存
     */
    public static final String CACHE_NAME_TENANT = "USER:tenant";
    /**
     * 分布式锁缓存前缀
     */
    public static final String DLOCK_PREFIX = "DLOCK:redssion";
    /**
     * 请求频率缓存前缀
     */
    public static final String REQ_RATE_PREFIX = "REQ:rate";
    /**
     * WMS叫料数据集合
     */
    public static final String CACHE_WMS_CALLMATERIAL = "SET:wms-callMaterial";
    /**
     * 用户配置
     */
    public static final String CACHE_NAME_USER_CONFIG = "CONFIG:user";



}
