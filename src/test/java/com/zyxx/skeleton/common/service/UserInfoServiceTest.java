package com.zyxx.skeleton.common.service;

import com.zyxx.SkeletonApplicationTests;
import com.zyxx.skeleton.common.entity.UserInfo;
import com.zyxx.skeleton.core.base.entity.BaseEntity;
import com.zyxx.skeleton.core.global.enums.CustomEnums;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserInfoServiceTest extends SkeletonApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 测试事物增强, 回滚
     */
    @Test
    public void test() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("test user 1");
        userInfo.setSalt("aaaaa");
        List<UserInfo> list = new ArrayList<>();
        list.add(userInfo);
        userInfoService.saveUserInfo(userInfo, list);
    }

    @Test
    public void testEntity() {
        BaseEntity entity = new BaseEntity();
        entity.setPage(1);
        entity.setLimit(10);
        System.out.println(entity.getOffset());
    }

    @Test
    public void testEnums() {
        CustomEnums.ok(200, "ZXCVBN");
        System.out.println(CustomEnums.OK.getCode());
        System.out.println(CustomEnums.OK.getInfo());

        CustomEnums.ok(400, "123456");
        System.out.println(CustomEnums.OK.getCode());
        System.out.println(CustomEnums.OK.getInfo());
    }
}
