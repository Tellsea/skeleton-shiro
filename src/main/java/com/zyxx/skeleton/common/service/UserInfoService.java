package com.zyxx.skeleton.common.service;

import com.zyxx.skeleton.common.entity.UserInfo;
import com.zyxx.skeleton.core.base.service.BaseService;
import com.zyxx.skeleton.core.layui.LayuiTable;

import java.util.List;

/**
 * 用户表 Service接口
 *
 * @author Tellsea
 * @date 2019-08-10
 */
public interface UserInfoService extends BaseService<UserInfo> {

    /**
     * 列表
     *
     * @param userInfo
     * @return
     */
    LayuiTable listUserInfo(UserInfo userInfo);

    /**
     * 保存用户信息（测试事物回滚）
     *
     * @param userInfo
     * @param userInfoList
     */
    void saveUserInfo(UserInfo userInfo, List<UserInfo> userInfoList);
}
