package org.lyflexi.custom_jetcache_framework.biz.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 8:24
 */
@Data
public class CacheDataUpdateParam {

    @NotBlank(message = "缓存key不能为空！")
    private String cacheKey;

    @NotBlank(message = "缓存数据不能为空！")
    private String dataJson;
}
