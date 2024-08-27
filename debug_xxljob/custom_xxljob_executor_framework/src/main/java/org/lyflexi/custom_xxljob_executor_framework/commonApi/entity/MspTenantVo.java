package org.lyflexi.custom_xxljob_executor_framework.commonApi.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 15:17
 */
@Data
public class MspTenantVo {

    private String id;

    private String code;

    private String name;

    private Integer status;

    private Integer active;

    private MspDataSourceVo dataSource;
}
