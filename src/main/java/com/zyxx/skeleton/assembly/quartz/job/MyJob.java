package com.zyxx.skeleton.assembly.quartz.job;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 测试任务
 *
 * @author Tellsea
 * @date 2019/9/7
 */
@Component
public class MyJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext arg0) {
        System.out.println(new Date() + "    job执行");
        // 获取参数
        JobDataMap jobDataMap = arg0.getJobDetail().getJobDataMap();
        // 业务逻辑 ...
        jobDataMap.entrySet().forEach(temp -> System.out.println("业务逻辑：" + temp.getKey() + " : " + temp.getValue()));
    }
}
