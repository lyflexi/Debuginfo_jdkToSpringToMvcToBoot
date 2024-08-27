package org.lyflexi.custom_xxljob_executor_framework.commonApi.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 15:19
 */
@Data
public class MspDataSourceVo {
    private String id;
    private String name;
    private String description;
    private String url;
    private String userName;
    private String password;
    private String driver;
    private Integer initPoolSize;
    private Integer maxPoolSize;
    private String tenantId;
    private Integer status;
    private String belong;
}