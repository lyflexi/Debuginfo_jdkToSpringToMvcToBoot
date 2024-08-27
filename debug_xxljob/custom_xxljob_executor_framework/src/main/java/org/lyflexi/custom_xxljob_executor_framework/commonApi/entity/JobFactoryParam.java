package org.lyflexi.custom_xxljob_executor_framework.commonApi.entity;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 15:29
 */

import lombok.Data;
import org.springframework.util.Assert;

/**
 * xxl-job 执行命令参数对象
 */
@Data
public class JobFactoryParam {

    private String factoryCode;

    public void assertParam () {
        Assert.notNull(this.factoryCode, "工厂编码为不能为空！");
    }
}
