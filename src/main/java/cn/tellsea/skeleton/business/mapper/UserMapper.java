package cn.tellsea.skeleton.business.mapper;

import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.core.base.mapper.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author Tellsea
 * @Description Created on 2019/07/16
 */
public interface UserMapper extends MyMapper<User> {

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    @Select(" SELECT * FROM `user` WHERE username = #{username} ")
    User getUserByUsername(String username);

    /**
     * 用户列表
     *
     * @return
     */
    List<User> listUser();
}
