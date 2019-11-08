package cn.tellsea.common.service;

import cn.tellsea.skeleton.component.layui.LayuiTable;
import cn.tellsea.skeleton.core.base.service.BaseService;
import cn.tellsea.common.entity.UserInfo;

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
