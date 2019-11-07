package com.zyxx;

import com.zyxx.common.entity.UserInfo;
import com.zyxx.common.service.UserInfoService;
import com.zyxx.skeleton.core.dto.ResponseResult;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
import com.zyxx.skeleton.service.TransactionService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Arrays;
import java.util.List;

@EnableAsync
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.zyxx.business.*.mapper")
public class SkeletonApplicationTests {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private TransactionService transactionService;

    @Test
    public void contextLoads() {
        System.out.println(ResponseResult.build(StatusEnums.SAVE_ERROR));
    }

    @Test
    public void password() {
        Md5Hash md5Hash = new Md5Hash("123456", "5jRDdrkfYL3VOJYT6ZgTY95jJ3q93q8A", 2);
        System.out.println(md5Hash);
        System.out.println(StringUtils.equals("a994fef0ddad5f9eed20804e7b18f559", md5Hash.toString()));
    }

    @Test
    public void testTr() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("测试事物");
        userInfo.setSalt("GJLDSFNOGLSNDLGNDFMGND");
        List<UserInfo> list = Arrays.asList(userInfo, userInfo, userInfo);
        userInfoService.saveUserInfo(userInfo, list);
        //userInfoService.saveUserInfo(userInfo, list);
    }
}
