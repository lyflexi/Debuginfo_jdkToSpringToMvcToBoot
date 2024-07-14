package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

/**
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/7/14 10:00
 */

@JobHandler(value = "@DeprecatedJobHandler")
public class SampleIJobHandler extends IJobHandler {
    @Override
    public void execute() throws Exception {
        System.out.println("@DeprecatedJobHandler start...");
    }
}