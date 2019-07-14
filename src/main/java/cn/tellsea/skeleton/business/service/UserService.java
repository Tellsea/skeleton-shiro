package cn.tellsea.skeleton.business.service;

import cn.tellsea.skeleton.business.entity.Resource;
import cn.tellsea.skeleton.business.entity.Role;
import cn.tellsea.skeleton.core.base.service.BaseService;
import cn.tellsea.skeleton.business.entity.User;

import java.util.List;

/**
 * User 接口
 *
 * @author Tellsea
 * @Description Created on 2019/07/13
 */
public interface UserService extends BaseService<User> {

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 根据id查询用户角色
     *
     * @param id
     * @return
     */
    List<Role> listUserRole(Long id);

    /**
     * 根据id查询所有资源
     *
     * @param id
     * @return
     */
    List<Resource> listUserResource(Long id);
}
