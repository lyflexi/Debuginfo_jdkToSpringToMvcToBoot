package org.lyflexi.custom_xxljob_executor_framework.commonApi.abstractTask;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 15:37
 */
public abstract class AbstractJobTask {

    /**
     * 设置当前任务上线文：
     *      1-用户上下文
     *      2-切换数据源
     * @param factoryCode 工厂编码
     * @param tenantId 租户ID
     */
    public void setContext (String factoryCode, String tenantId) {

    }

    /**
     * 清空当前任务上线文：
     *      1-用户上下文
     *      2-切换数据源
     */
    public void clearContext () {

    }
}
