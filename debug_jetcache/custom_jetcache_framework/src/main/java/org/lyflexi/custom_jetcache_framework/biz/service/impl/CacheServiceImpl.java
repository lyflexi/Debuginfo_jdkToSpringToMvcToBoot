package org.lyflexi.custom_jetcache_framework.biz.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.lyflexi.custom_jetcache_framework.biz.entity.CacheKeysVo;
import org.lyflexi.custom_jetcache_framework.biz.service.ICacheService;
import org.lyflexi.custom_jetcache_framework.commonApi.exception.LyFlexiBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 8:27
 */
@Slf4j
@Service
public class CacheServiceImpl implements ICacheService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * --------------------------------------------------- 查询所有Keys --------------------------------------------------
     */
    public List<CacheKeysVo> scanKeys (String keyPattern) {
        if (keyPattern.startsWith("*")) {
            throw LyFlexiBusinessException.exception("禁止缓存key右匹配查询模式：[* patterns]！");
        }
        return redisTemplate.execute((RedisCallback<List<CacheKeysVo>>) connection -> {
            List<CacheKeysVo> keysVos = new ArrayList<>();
            try (Cursor<byte[]> cursor = connection.scan(ScanOptions.scanOptions().match(keyPattern).count(1000).build())) {
                while (cursor.hasNext()) {
                    String key = new String(cursor.next(), StandardCharsets.UTF_8);
                    Long expire = redisTemplate.getExpire(key);
                    keysVos.add(CacheKeysVo.of(key, expire));
                }
            } catch (Exception e) {
                throw LyFlexiBusinessException.exception("缓存查询错误！");
            }
            return keysVos;
        });
    }
}
