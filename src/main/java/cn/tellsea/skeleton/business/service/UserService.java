package cn.tellsea.skeleton.business.service;

import cn.tellsea.skeleton.business.dto.TableDataDTO;
import cn.tellsea.skeleton.core.base.service.BaseService;
import cn.tellsea.skeleton.business.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * User 接口
 *
 * @author Tellsea
 * @Description Created on 2019/07/16
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
     * 用户列表分页
     *
     * @param pn
     * @return
     */
    PageInfo<User> listUserByPage(Integer pn);

    /**
     * 查询用户列表
     *
     * @param tableDataDTO
     * @return
     */
    TableDataDTO listUser(TableDataDTO<User> tableDataDTO);
}
