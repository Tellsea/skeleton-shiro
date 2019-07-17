package cn.tellsea.skeleton.business.service;

import cn.tellsea.SkeletonApplicationTests;
import cn.tellsea.skeleton.business.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceTest extends SkeletonApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.insert(new User());
    }

}
