package com.zyxx.customized.service.impl;

import com.zyxx.customized.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * 异步方法 实现类
 *
 * @author: Tellsea
 * @date: 2019/09/10
 */
@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    int i = 0;
    @Async
    @Override
    public Future<String> exampleAsync() {
        try {
            Thread.sleep(1000);
            log.info("方法体，这里是异步执行的{}", i);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        return new AsyncResult<>("exampleAsync 执行完毕");
    }

    @Async("asyncServiceExecutor")
    @Override
    public void executeAsync() {
        try {
            Thread.sleep(1000);
            log.info("方法体，这里是异步执行的");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("end executeAsync");
    }
}