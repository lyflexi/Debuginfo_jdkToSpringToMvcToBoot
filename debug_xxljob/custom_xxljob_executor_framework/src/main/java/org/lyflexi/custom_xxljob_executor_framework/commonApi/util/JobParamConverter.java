package org.lyflexi.custom_xxljob_executor_framework.commonApi.util;

import org.lyflexi.custom_xxljob_executor_framework.commonApi.entity.JobFactoryParam;
import org.springframework.util.Assert;
import com.alibaba.fastjson.JSON;
/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 15:28
 */
public class JobParamConverter {

    public static <T extends JobFactoryParam> T parseAndCheckJobParam(String paramJson, Class<T> clazz) {
        T param = JSON.parseObject(paramJson, clazz);
        Assert.notNull(param, "jobParam参数为不能为空！");
        param.assertParam();
        return param;
    }
}