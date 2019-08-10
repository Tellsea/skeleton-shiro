package cn.tellsea.skeleton.common.service;

import cn.tellsea.skeleton.common.entity.UserInfo;
import cn.tellsea.skeleton.core.base.service.BaseService;
import cn.tellsea.skeleton.core.layui.LayuiTable;

/**
 * 用户表 Service接口
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
 */
public interface UserInfoService extends BaseService<UserInfo> {

    /**
     * 列表
     *
     * @param userInfo
     * @return
     */
    LayuiTable listUserInfo(UserInfo userInfo);
}
