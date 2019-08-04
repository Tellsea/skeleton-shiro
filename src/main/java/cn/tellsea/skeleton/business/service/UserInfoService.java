package cn.tellsea.skeleton.business.service;

import cn.tellsea.skeleton.business.entity.UserInfo;
import cn.tellsea.skeleton.business.entity.vo.UserInfoVo;
import cn.tellsea.skeleton.core.layui.LayuiPage;

import java.util.List;

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

    /**
     * 用户列表
     *
     * @param userInfo
     * @param layuiPage
     * @return
     */
    List<UserInfoVo> listUserInfo(UserInfo userInfo, LayuiPage layuiPage);

    /**
     * 用户列表计数
     *
     * @param userInfo
     * @return
     */
    int countUserInfo(UserInfo userInfo);
}
