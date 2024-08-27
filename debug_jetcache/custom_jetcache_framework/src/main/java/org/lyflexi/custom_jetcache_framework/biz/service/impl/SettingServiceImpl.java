package org.lyflexi.custom_jetcache_framework.biz.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.lyflexi.custom_jetcache_framework.biz.feign.MSPProvider;
import org.lyflexi.custom_jetcache_framework.commonApi.entity.SettingPo;
import org.lyflexi.custom_jetcache_framework.commonApi.entity.SettingVo;
import org.lyflexi.custom_jetcache_framework.commonApi.result.Result;
import org.lyflexi.custom_jetcache_framework.commonApi.service.ISettingService;
import org.lyflexi.custom_jetcache_framework.commonApi.util.Assert;
import org.lyflexi.custom_jetcache_framework.commonApi.util.VOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/15 13:38
 */

@Slf4j
@Service
public class SettingServiceImpl implements ISettingService {

    @Autowired
    private MSPProvider mspProvider;

    @Override
    public SettingVo getSetting(String tenantId, String configKey) {
        Assert.notBlack(tenantId, "租户ID不能为空！");
        Assert.notBlack(configKey, "参数Key不能为空！");
        log.info("缓存失效调用MSP接口获取setting数据，tenantId:{}, configKey:{}", tenantId, configKey);
        Result<List<SettingPo>> result = mspProvider.queryAllSetting(tenantId);
        if (Objects.isNull(result)) {
            log.error("调用MSP接口获取Setting数据响应为空！");
            return null;
        }
        if (!result.isSuccess()) {
            log.error("调用MSP接口获取Setting数据响应失败：{}", JSON.toJSONString(result));
            return null;
        }
        if (CollectionUtils.isEmpty(result.getData())) {
            log.error("调用MSP接口获取Setting数据为空：{}", JSON.toJSONString(result));
            return null;
        }
        SettingPo settingPo = result.getData().stream().filter(Objects::nonNull)
                .filter(setting -> StringUtils.equals(configKey, setting.getConfigKey())).findFirst().orElse(null);
        return VOUtil.convert(settingPo, SettingVo.class);
    }
}
