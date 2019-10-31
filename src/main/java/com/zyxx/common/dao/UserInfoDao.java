package com.zyxx.common.dao;

import com.zyxx.common.entity.UserInfo;
import com.zyxx.common.vo.UserInfoVo;
import com.zyxx.skeleton.core.base.dao.BaseDao;

import java.util.List;

/**
 * 用户表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-10-31
 */
public interface UserInfoDao extends BaseDao<UserInfo> {

    List<UserInfoVo> listUserInfo(UserInfo userInfo);
}