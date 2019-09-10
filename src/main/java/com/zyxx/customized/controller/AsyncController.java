package com.zyxx.customized.controller;

import com.zyxx.customized.service.AsyncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * 异步方法示例 控制器
 *
 * @author: Tellsea
 * @date: 2019/09/10
 */
@Api(tags = "异步方法示例")
@Slf4j
@RestController
@RequestMapping("async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @ApiOperation("测试异步")
    @GetMapping("example")
    public String example() {
        Future<String> future = asyncService.exampleAsync();
        System.out.println(future);
        return "success";
    }
}