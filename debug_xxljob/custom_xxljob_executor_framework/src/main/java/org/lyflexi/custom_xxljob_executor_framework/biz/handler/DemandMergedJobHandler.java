package org.lyflexi.custom_xxljob_executor_framework.biz.handler;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 15:38
 */
@Slf4j
@Component
public class DemandMergedJobHandler {



    /**
     * 需求合并执行器
     * @param mergeRuleCode 合单编码
     * @param urgentStatus 紧急叫料状态
     */
    public void process (String mergeRuleCode, String urgentStatus) {
        try {
            log.info("当前合并执行完成");
        } catch (Exception e) {
            log.error("当前合并执行错误：{}", mergeRuleCode, e);
        }
    }
}
