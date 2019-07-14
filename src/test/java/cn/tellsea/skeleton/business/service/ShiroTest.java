package cn.tellsea.skeleton.business.service;

import cn.tellsea.SkeletonApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroTest extends SkeletonApplicationTests {

    @Autowired
    private UserService userService;

    /**
     * 根据用户名查询用户
     */
    @Test
    public void getUserByUsername() {
        System.out.println(userService.getUserByUsername("tellsea"));
    }

    /**
     * 查询用户角色
     */
    @Test
    public void listUserRole() {
        userService.listUserRole(1L).forEach(role -> System.out.println(role.getName()));
    }

    /**
     * 查询用户资源
     */
    @Test
    public void listUserResource() {
        userService.listUserResource(1L).forEach(resource -> System.out.println(resource.getName()));
    }
}
