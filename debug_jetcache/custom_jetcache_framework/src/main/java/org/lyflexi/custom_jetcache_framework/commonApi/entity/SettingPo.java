package org.lyflexi.custom_jetcache_framework.commonApi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/15 13:42
 */
@Data
public class SettingPo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String configName;

    private String configKey;

    private String configValue;

    private String configType;
}
