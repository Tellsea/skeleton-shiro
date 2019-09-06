package com.zyxx.skeleton.assembly.async;

import com.zyxx.SkeletonApplication;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Future;

public class TestAsyncTest extends SkeletonApplication {

    @Autowired
    private TestAsync testAsync;

    @Test
    public void test() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Future<String> task1 = testAsync.task1();
        Future<String> task2 = testAsync.task2();
        Future<String> task3 = testAsync.task3();
        String result = null;
        for (; ; ) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        result = "task任务总耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms";
        System.out.println(result);
    }
}