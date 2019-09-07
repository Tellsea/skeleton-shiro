package com.zyxx.customized.controller;

import com.zyxx.customized.service.QuartzService;
import com.zyxx.skeleton.assembly.quartz.job.MyJob;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * quartz 定时器控制器
 *
 * @author Tellsea
 * @date 2019/9/7
 * 参考文章：https://blog.csdn.net/u012954706/article/details/79671442
 */
@Api(tags = "定时器")
@RestController
@RequestMapping("quartz")
public class QuartzController {

    @Autowired
    private QuartzService quartzService;

    @GetMapping("addJob")
    @ApiOperation("新增")
    public void addJob() {
        Map map = new HashMap(2);
        map.put("id", 1L);
        quartzService.addJob(MyJob.class, "job", "test", "0/5 * * * * ?", map);
    }

    @GetMapping("updateJob")
    @ApiOperation("更新")
    public void updateJob() {
        quartzService.updateJob("job", "test", "0/10 * * * * ?");
    }

    @GetMapping("deleteJob")
    @ApiOperation("删除")
    public void deleteJob() {
        quartzService.deleteJob("job", "test");
    }

    @GetMapping("pauseJob")
    @ApiOperation("暂停")
    public void pauseJob() {
        quartzService.pauseJob("job", "test");
    }

    @GetMapping("resumeJob")
    @ApiOperation("恢复")
    public void resumeJob() {
        quartzService.resumeJob("job", "test");
    }

    @GetMapping("runAJobNow")
    @ApiOperation("立即执行")
    public void runAJobNow() {
        quartzService.runAJobNow("job", "test");
    }

    @GetMapping("queryAllJob")
    @ApiOperation("所有任务列表")
    public void queryAllJob() {
        List<Map<String, Object>> list = quartzService.queryAllJob();
        list.forEach(temp -> {
            temp.entrySet().forEach(map -> {
                System.out.println(map.getKey() + " : " + map.getValue());
            });
        });
    }

    @GetMapping("queryRunJob")
    @ApiOperation("所有任务列表（运行中）")
    public void queryRunJob() {
        List<Map<String, Object>> list = quartzService.queryRunJob();
        list.forEach(temp -> {
            temp.entrySet().forEach(map -> {
                System.out.println(map.getKey() + " : " + map.getValue());
            });
        });
    }
}
