package com.zyxx;

import com.zyxx.skeleton.core.dto.ResponseResult;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

@EnableAsync
@RunWith(SpringRunner.class)
@SpringBootTest
public class SkeletonApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(ResponseResult.build(StatusEnums.SAVE_ERROR));
    }

}
