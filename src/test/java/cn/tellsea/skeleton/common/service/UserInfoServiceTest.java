package cn.tellsea.skeleton.common.service;

import cn.tellsea.SkeletonApplicationTests;
import cn.tellsea.skeleton.common.entity.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserInfoServiceTest extends SkeletonApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void test() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("test user 1");
        userInfo.setSalt("aaaaa");
        List<UserInfo> list = new ArrayList<>();
        list.add(userInfo);
        userInfoService.saveUserInfo(userInfo, list);
    }
}
