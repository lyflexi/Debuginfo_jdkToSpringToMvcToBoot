package org.lyflexi.custom_jetcache_framework.biz.feign;

import org.lyflexi.custom_jetcache_framework.commonApi.entity.SettingPo;
import org.lyflexi.custom_jetcache_framework.commonApi.result.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/15 13:50
 */
@Service
public class MSPProviderFake implements MSPProvider{
    @Override
    public Result<List<SettingPo>> queryAllSetting(String tenantId) {
        ArrayList<SettingPo> settingPos = new ArrayList<>();
        SettingPo settingPo1 = new SettingPo();
        settingPo1.setId("1");
        settingPo1.setConfigKey("settingPo1");
        settingPo1.setConfigName("settingPo1");
        settingPo1.setConfigType("settingPo1");
        settingPo1.setConfigValue("settingPo1");
        SettingPo settingPo2 = new SettingPo();
        settingPo2.setId("2");
        settingPo2.setConfigKey("settingPo2");
        settingPo2.setConfigName("settingPo2");
        settingPo2.setConfigType("settingPo2");
        settingPo2.setConfigValue("settingPo2");
        settingPos.add(settingPo1);
        settingPos.add(settingPo2);
        return Result.success(settingPos);
    }
}
