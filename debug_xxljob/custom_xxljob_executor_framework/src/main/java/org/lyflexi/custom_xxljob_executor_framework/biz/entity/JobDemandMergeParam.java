package org.lyflexi.custom_xxljob_executor_framework.biz.entity;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 15:30
 */
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.lyflexi.custom_xxljob_executor_framework.commonApi.entity.JobFactoryParam;
import org.springframework.util.Assert;

/**
 * xxl-job 执行命令参数对象
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class JobDemandMergeParam extends JobFactoryParam {

    private String mergeRuleCode;

    private String urgentStatus;

    public void assertParam () {
        super.assertParam();
        Assert.notNull(this.mergeRuleCode, "合单规则编码为不能为空！");
    }
}