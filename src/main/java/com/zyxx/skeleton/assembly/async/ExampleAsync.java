package com.zyxx.skeleton.assembly.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 异步调用方法
 *
 * @author Tellsea
 * @date 2019/9/6
 */
@Component
public class ExampleAsync {

    @Async
    public Future<String> exampleAsync() {
        // 方法体，这里是异步执行的
        System.out.println(111111);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("exampleAsync 执行完毕");
    }
}
