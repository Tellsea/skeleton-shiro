package cn.tellsea.skeleton.business.mapper;

import cn.tellsea.skeleton.business.entity.Resource;
import cn.tellsea.skeleton.business.entity.Role;
import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.core.base.mapper.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author Tellsea
 * @Description Created on 2019/07/13
 */
public interface UserMapper extends MyMapper<User> {

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    @Select("SELECT * FROM `user` u WHERE u.username = #{username}")
    User getUserByUsername(String username);

    /**
     * 根据id查询所有资源
     *
     * @param id
     * @return
     */
    List<Resource> listUserResource(Long id);

    /**
     * 根据id查用户角色
     *
     * @param id
     * @return
     */
    List<Role> listUserRole(Long id);
}
