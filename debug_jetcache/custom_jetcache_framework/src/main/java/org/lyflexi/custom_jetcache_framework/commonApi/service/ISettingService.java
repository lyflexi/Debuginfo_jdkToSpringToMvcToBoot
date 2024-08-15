package org.lyflexi.custom_jetcache_framework.commonApi.service;

import org.lyflexi.custom_jetcache_framework.commonApi.entity.SettingVo;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/15 13:33
 */
public interface ISettingService {
    /**
     * 根据字典类型查询字典数据，请求参数不能为空，空了可能会出大问题，实现端自己校验
     * @param tenantId 租户编号
     * @param configKey 配置Key
     * @return SettingPo
     */
    SettingVo getSetting (String tenantId, String configKey);
}
