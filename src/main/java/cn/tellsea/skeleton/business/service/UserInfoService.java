package cn.tellsea.skeleton.business.service;

import cn.tellsea.skeleton.business.entity.UserInfo;

/**
 * 用户表 Service接口
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
public interface UserInfoService {

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    UserInfo getUserInfoByName(String username);
}
