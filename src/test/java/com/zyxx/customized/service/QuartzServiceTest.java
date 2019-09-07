package com.zyxx.customized.service;

import com.zyxx.SkeletonApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class QuartzServiceTest extends SkeletonApplicationTests {

    @Autowired
    private QuartzService quartzService;

    @Test
    public void test() {
        quartzService.startScheduler();
    }
}
