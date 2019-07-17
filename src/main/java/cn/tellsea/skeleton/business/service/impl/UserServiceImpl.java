package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.business.mapper.UserMapper;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import cn.tellsea.skeleton.business.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User 接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019/07/16
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public PageInfo<User> listUserByPage(Integer pn) {
        PageHelper.startPage(pn, 10);
        return new PageInfo<>(userMapper.listUserByPage());
    }
}
