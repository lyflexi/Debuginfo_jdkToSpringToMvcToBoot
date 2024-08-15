package org.lyflexi.custom_jetcache_framework.commonApi.jet;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/15 13:31
 */
public interface IJetcacher {

    /**
     * 查询缓存
     * @param cacheKeyPartSuffix 缓存key，不携带缓存名称
     * @return 缓存数据对象 valueObj
     */
    Object getValue (String cacheKeyPartSuffix);

    /**
     * 更新缓存
     * @param cacheKeyPartSuffix 缓存key，不携带缓存名称
     * @param valueObj 缓存数据对象
     */
    boolean updateValue (String cacheKeyPartSuffix, Object valueObj);

    /**
     * 删除缓存
     * @param cacheKeyPartSuffix 缓存key，不携带缓存名称
     */
    boolean delValue (String cacheKeyPartSuffix);

    /**
     * 缓存数据转换
     * @param cacheKeyPartSuffix 缓存key，不携带缓存名称
     * @param valueStr 缓存数据字符串
     * @return valueObj
     */
    Object convertValue (String cacheKeyPartSuffix, String valueStr);
}
