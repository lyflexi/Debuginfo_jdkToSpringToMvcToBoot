package org.lyflexi.custom_jetcache_framework.commonApi.facade;

import lombok.extern.slf4j.Slf4j;
import org.lyflexi.custom_jetcache_framework.commonApi.entity.SettingVo;
import org.lyflexi.custom_jetcache_framework.commonApi.holder.LyFlexiUserContextHolder;
import org.lyflexi.custom_jetcache_framework.commonApi.jet.SettingJetcacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/15 13:22
 */

@Slf4j
@Component
public class CacheSettingFacade {

    @Autowired
    private SettingJetcacher settingJetcacher;

    /**
     * 根据configKey查询系统参数
     * @param configKey configKey
     * @return SettingPo
     */
    public SettingVo getSetting (String configKey) {
        return this.getSetting(LyFlexiUserContextHolder.getInstance().getTenantId(), configKey);
    }

    /**
     * 根据configKey查询系统参数
     * @param tenantId 租户编号
     * @param configKey configKey
     * @return SettingPo
     */
    public SettingVo getSetting (String tenantId, String configKey) {
        return settingJetcacher.getSetting(tenantId, configKey);
    }
}
