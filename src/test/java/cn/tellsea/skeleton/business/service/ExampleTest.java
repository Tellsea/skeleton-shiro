package cn.tellsea.skeleton.business.service;

import cn.tellsea.SkeletonApplicationTests;
import cn.tellsea.skeleton.business.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

/**
 * 条件查询测试
 *
 * @author Tellsea
 * @Description Created on 2019/7/20
 */
public class ExampleTest extends SkeletonApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testExample() {

        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        // 2、构造条件
        // 当 username 像 tel
        criteria.andLike("username", "%tel%");
        // 当 id = 4
        criteria.andEqualTo("id", 4);
        // 当创建时间在之间
        criteria.andBetween("createTime", "2019-06-22", "2019-06-23");
        // 将此对象的不为空的字段参数作为相等查询条件
        User userCriteria = new User();
        userCriteria.setUsername("tellsea");
        criteria.andEqualTo(userCriteria);
        // 且不等于
        criteria.andNotEqualTo("status", 1);
        // 或不等于
        criteria.orNotEqualTo("status", 1);
        // 当状态在 1、2 中
        List<Integer> inList = Arrays.asList(1, 2);
        criteria.andIn("status", inList);

        // 3、执行
        List<User> userList = userService.selectByExample(example);
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void testName() {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deptId", 7);
        List<User> list = userService.selectByExample(example);
        list.forEach(user -> System.out.println(user));
    }
}
