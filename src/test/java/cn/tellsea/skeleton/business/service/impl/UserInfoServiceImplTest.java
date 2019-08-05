package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.SkeletonApplicationTests;
import cn.tellsea.skeleton.business.service.UserInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserInfoServiceImplTest extends SkeletonApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void test1() {
        userInfoService.test();
    }
}
