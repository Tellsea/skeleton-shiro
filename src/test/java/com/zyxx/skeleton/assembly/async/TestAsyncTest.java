package com.zyxx.skeleton.assembly.async;

import com.zyxx.SkeletonApplication;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Future;

public class TestAsyncTest extends SkeletonApplication {

    @Autowired
    private ExampleAsync exampleAsync;

    @Test
    public void test() {
        Future<String> future = exampleAsync.exampleAsync();
        System.out.println(future);
    }
}
