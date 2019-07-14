package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.entity.Resource;
import cn.tellsea.skeleton.business.entity.Role;
import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.business.mapper.UserMapper;
import cn.tellsea.skeleton.business.service.UserService;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import cn.tellsea.skeleton.core.common.enums.StatusEnums;
import cn.tellsea.skeleton.core.common.exception.SkeletonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User 接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019/07/13
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
    public List<Role> listUserRole(Long id) {
        if (id == 0) {
            throw new SkeletonException(StatusEnums.PARAM_NOT_NULL);
        }
        return userMapper.listUserRole(id);
    }

    @Override
    public List<Resource> listUserResource(Long id) {
        return userMapper.listUserResource(id);
    }
}
