package org.lyflexi.custom_jetcache_framework.biz;

import cn.hutool.core.util.URLUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.lyflexi.custom_jetcache_framework.biz.entity.CacheDataUpdateParam;
import org.lyflexi.custom_jetcache_framework.biz.entity.CacheKeysVo;
import org.lyflexi.custom_jetcache_framework.biz.service.ICacheService;
import org.lyflexi.custom_jetcache_framework.commonApi.constant.CacheConstant;
import org.lyflexi.custom_jetcache_framework.commonApi.holder.JetCacherHolder;
import org.lyflexi.custom_jetcache_framework.commonApi.result.Result;
import org.lyflexi.custom_jetcache_framework.commonApi.util.Assert;
import org.lyflexi.custom_jetcache_framework.commonApi.util.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 8:14
 */
@RestController
@RequestMapping("/cache")
//@RefreshScope ： SpringCloud注解
@Slf4j
public class CacheController {

    @Autowired
    private ICacheService cacheService;

    /**
     * 查看缓存Keys
     * @param keyPattern Key前缀
     * @return
     */
    @GetMapping("/keys")
    public Result<List<CacheKeysVo>> keys (@RequestParam String keyPattern) {
        log.info("查看缓存Keys：{}", keyPattern);
        Assert.notBlack(keyPattern, "keyPattern不能为空！");
        return Result.success(cacheService.scanKeys(keyPattern));
    }

    /**
     * 查看缓存数据
     * @param cacheKey Key
     * @return
     */
    @GetMapping("/get")
    public Result<Object> get (@RequestParam String cacheKey) {
        log.info("查看缓存数据：{}", cacheKey);
        Assert.notBlack(cacheKey, "cacheKey不能为空！");
        return Result.success(JetCacherHolder.getValue(cacheKey));
    }

    /**
     * 更新缓存数据
     * @param param
     * @return
     */
    @PutMapping("/update")
    public Result<Object> update (@RequestBody @Valid CacheDataUpdateParam param) {
        log.info("更新缓存数据：{}", JSON.toJSONString(param));
        String dataJson = URLUtil.decode(param.getDataJson());
        log.info("解码后缓存数据：{}", dataJson);
//        String cacheKey = RedisKey.generator(CacheConstant.CACHE_NAME_SETTING,tenantId,configKey);
        return Result.success(JetCacherHolder.updateValue(param.getCacheKey(), dataJson));
    }

    /**
     * 删除缓存
     * @param cacheKey 缓存key
     * @return
     */
    @DeleteMapping("/clear")
    public Result<?> clearCache (@RequestParam String cacheKey) {
        Assert.notBlack(cacheKey, "cacheKey不能为空！");
        return Result.success(JetCacherHolder.delValue(cacheKey));
    }
}
