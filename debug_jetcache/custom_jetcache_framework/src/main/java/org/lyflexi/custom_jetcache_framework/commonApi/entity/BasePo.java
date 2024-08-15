package org.lyflexi.custom_jetcache_framework.commonApi.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/15 13:44
 */

@Data
@Accessors(chain = true)
public class BasePo {
    public final static String DEFAULT_USERNAME = "system";


    private Long id;


    private LocalDateTime addTime;


    private String addUserName;


    private String addUserCode;


    private String editUserName;


    private String editUserCode;


    private LocalDateTime editTime;


    private Integer dataStatus;


    private String factoryCode;
}
