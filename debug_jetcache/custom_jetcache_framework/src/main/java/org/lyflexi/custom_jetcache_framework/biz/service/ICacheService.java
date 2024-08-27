package org.lyflexi.custom_jetcache_framework.biz.service;

import org.lyflexi.custom_jetcache_framework.biz.entity.CacheKeysVo;

import java.util.List;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 8:27
 */

public interface ICacheService {

    /**
     * --------------------------------------------------- 查询所有Keys --------------------------------------------------
     */
    List<CacheKeysVo> scanKeys (String keyPattern);
}

