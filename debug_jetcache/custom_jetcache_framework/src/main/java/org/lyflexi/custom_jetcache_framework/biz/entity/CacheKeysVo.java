package org.lyflexi.custom_jetcache_framework.biz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 8:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CacheKeysVo {

    private String cacheKey;

    private Long expire;

    public static CacheKeysVo of (String cacheKey, Long expire) {
        return new CacheKeysVo(cacheKey, expire);
    }
}