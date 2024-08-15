package org.lyflexi.custom_jetcache_framework.commonApi.jet;

import com.alibaba.fastjson.JSON;
import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import lombok.extern.slf4j.Slf4j;
import org.lyflexi.custom_jetcache_framework.commonApi.constant.CacheConstant;
import org.lyflexi.custom_jetcache_framework.commonApi.entity.SettingVo;
import org.lyflexi.custom_jetcache_framework.commonApi.service.ISettingService;
import org.lyflexi.custom_jetcache_framework.commonApi.util.Assert;
import org.lyflexi.custom_jetcache_framework.commonApi.util.SpringUtils;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/15 13:30
 */
@Slf4j
@Component
public class SettingJetcacher implements IJetcacher {

    /**
     * 根据configKey查询系统参数
     * @param tenantId 租户编号
     * @param configKey configKey
     * @return SettingVo
     */
    @Cached(name = CacheConstant.CACHE_NAME_SETTING, key = "':' + #tenantId + ':'+ #configKey", expire = CacheConstant.CACHE_EXPIRE)
    public SettingVo getSetting (String tenantId, String configKey) {
        Assert.notBlack(tenantId, "租户ID不能为空！");
        Assert.notBlack(configKey, "参数Key不能为空！");
        log.info("缓存失效：{}，{}", tenantId, configKey);
        ISettingService settingService = SpringUtils.getBean(ISettingService.class);
        return settingService.getSetting(tenantId, configKey);
    }

    @Override
    @Cached(name = CacheConstant.CACHE_NAME_SETTING, key = "#cacheKeyPartSuffix")
    public Object getValue(String cacheKeyPartSuffix) {
        log.info("缓存查询失效：key={}{}", CacheConstant.CACHE_NAME_SETTING, cacheKeyPartSuffix);
        return true;
    }

    @Override
    @CacheUpdate(name = CacheConstant.CACHE_NAME_SETTING, key = "#cacheKeyPartSuffix", value = "#valueObj")
    public boolean updateValue(String cacheKeyPartSuffix, Object valueObj) {
        log.info("缓存更新成功：key={}{}, value={}", CacheConstant.CACHE_NAME_SETTING, cacheKeyPartSuffix, JSON.toJSONString(valueObj));
        return true;
    }

    @Override
    @CacheInvalidate(name = CacheConstant.CACHE_NAME_SETTING, key = "#cacheKeyPartSuffix")
    public boolean delValue(String cacheKeyPartSuffix) {
        log.info("缓存删除成功：key={}{}", CacheConstant.CACHE_NAME_SETTING, cacheKeyPartSuffix);
        return true;
    }

    @Override
    public Object convertValue(String cacheKeyPartSuffix, String valueStr) {
        return JSON.parseObject(valueStr, SettingVo.class);
    }
}
