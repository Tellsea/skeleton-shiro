package com.zyxx;

import com.zyxx.skeleton.core.global.dto.ResponseResult;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class SkeletonApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(ResponseResult.build(StatusEnums.SAVE_ERROR));
    }

}
