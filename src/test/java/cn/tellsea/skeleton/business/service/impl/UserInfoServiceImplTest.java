package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.SkeletonApplicationTests;
import cn.tellsea.skeleton.business.entity.UserInfo;
import cn.tellsea.skeleton.business.mapper.UserInfoMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import static org.junit.Assert.*;

public class UserInfoServiceImplTest extends SkeletonApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void save() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("test");
        userInfoMapper.insertSelective(userInfo);
        System.out.println(userInfo.getId());
    }

    @Test
    public void listUserInfo() {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        userInfoMapper.selectByExample(example);
    }
}
