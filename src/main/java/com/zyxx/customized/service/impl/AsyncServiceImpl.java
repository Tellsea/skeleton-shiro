package com.zyxx.customized.service.impl;

import com.zyxx.customized.service.AsyncService;
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
@Service
public class AsyncServiceImpl implements AsyncService {

    @Async
    @Override
    public Future<String> exampleAsync() {
        try {
            Thread.sleep(10000);
            // 方法体，这里是异步执行的
            System.out.println(111111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("exampleAsync 执行完毕");
    }
}