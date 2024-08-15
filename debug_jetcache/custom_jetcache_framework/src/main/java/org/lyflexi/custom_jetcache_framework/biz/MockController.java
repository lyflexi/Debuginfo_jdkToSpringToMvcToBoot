package org.lyflexi.custom_jetcache_framework.biz;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.lyflexi.custom_jetcache_framework.commonApi.entity.SettingVo;
import org.lyflexi.custom_jetcache_framework.commonApi.facade.CacheSettingFacade;
import org.lyflexi.custom_jetcache_framework.commonApi.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/13 18:55
 */


@RestController
@RequestMapping("/mock")
@Slf4j
public class MockController {
    @Autowired
    private CacheSettingFacade settingFacade;

    @GetMapping(value = "/get")
    public Result<SettingVo> getSetting (@RequestParam String configKey) {
        SettingVo settingVo = settingFacade.getSetting(configKey);
        if (Objects.nonNull(settingVo)) {
            return Result.data(settingVo);
        }
        return Result.fail("未查询到系统参数！");
    }
}
