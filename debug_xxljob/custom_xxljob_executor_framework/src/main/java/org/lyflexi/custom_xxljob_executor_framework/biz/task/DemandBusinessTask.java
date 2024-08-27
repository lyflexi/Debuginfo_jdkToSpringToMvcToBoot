package org.lyflexi.custom_xxljob_executor_framework.biz.task;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.lyflexi.custom_xxljob_executor_framework.biz.CacheTenantFacade;
import org.lyflexi.custom_xxljob_executor_framework.biz.entity.JobDemandMergeParam;
import org.lyflexi.custom_xxljob_executor_framework.biz.handler.DemandMergedJobHandler;
import org.lyflexi.custom_xxljob_executor_framework.commonApi.abstractTask.AbstractJobTask;
import org.lyflexi.custom_xxljob_executor_framework.commonApi.entity.MspTenantVo;
import org.lyflexi.custom_xxljob_executor_framework.commonApi.util.Assert;
import org.lyflexi.custom_xxljob_executor_framework.commonApi.util.JobParamConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 15:11
 */
@Component
@Slf4j
public class DemandBusinessTask extends AbstractJobTask {

    @Autowired
    private CacheTenantFacade tenantFacade;

    @Autowired
    private DemandMergedJobHandler demandMergedJobHandler;


    /**
     * 需求合并定时任务 单位：毫秒，设定每5min执行一次
     * 后面会接入分布式调度系统，所以这里不需要分布式锁
     */
//    @Scheduled(fixedRate = 300 * 1000)
    @XxlJob("demandMergeTaskHandler")
    public void demandMergeTask () {
        String jobParam = XxlJobHelper.getJobParam();
        log.info(">>>>>>>>[demandMergeTaskHandler]收到调度中心执行命令，当前参数：{}", jobParam);
        JobDemandMergeParam param = JobParamConverter.parseAndCheckJobParam(jobParam, JobDemandMergeParam.class);
        MspTenantVo tenantVo = tenantFacade.getByFactoryCode(param.getFactoryCode());
        Assert.notNull(tenantVo, MessageFormat.format("[{0}]未查询到租户信息！", param.getFactoryCode()));
        Assert.notBlack(tenantVo.getId(), "租户ID不能为空！");
        Assert.notBlack(param.getMergeRuleCode(), "合单策略编码不能为空！");
        try {
            log.info("需求合并任务执行开始，参数：{} {} {}", param.getFactoryCode(), tenantVo.getId(), param.getMergeRuleCode());
            super.setContext(param.getFactoryCode(), tenantVo.getId());
            long start = System.currentTimeMillis();
            demandMergedJobHandler.process(param.getMergeRuleCode(), param.getUrgentStatus());
            log.info("需求合并定时任务执行结束，耗时：{}ms.", System.currentTimeMillis() - start);
        } finally {
            super.clearContext();
        }
    }
}
