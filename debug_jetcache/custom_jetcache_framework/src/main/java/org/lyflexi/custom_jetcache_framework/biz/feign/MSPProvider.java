package org.lyflexi.custom_jetcache_framework.biz.feign;

import org.lyflexi.custom_jetcache_framework.commonApi.constant.LyFlexiConstant;
import org.lyflexi.custom_jetcache_framework.commonApi.entity.SettingPo;
import org.lyflexi.custom_jetcache_framework.commonApi.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/15 13:45
 */
//@FeignClient(name = "msp-system", fallback = MspProviderFallback.class)
public interface MSPProvider {

    @GetMapping(value = "setting/queryAllSetting")
    Result<List<SettingPo>> queryAllSetting(@RequestHeader(LyFlexiConstant.X_TENANT_ID) String tenantId);


}
