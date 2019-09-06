package com.zyxx.common.service.impl;

import com.zyxx.common.dao.UserInfoDao;
import com.zyxx.common.entity.UserInfo;
import com.zyxx.common.vo.UserInfoVo;
import com.zyxx.common.service.UserInfoService;
import com.zyxx.skeleton.core.base.service.impl.BaseServiceImpl;
import com.zyxx.skeleton.assembly.layui.LayuiTable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表 Service接口实现类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, UserInfoDao> implements UserInfoService {

    @Override
    public LayuiTable listUserInfo(UserInfo userInfo) {
        // todo 不能模糊查询
        int count = baseMapper.selectCount(userInfo);
        List<UserInfoVo> list = null;
        if (0 < count) {
            list = baseDao.listUserInfo(userInfo);
        }
        return LayuiTable.build(count, list);
    }

    @Override
    public void saveUserInfo(UserInfo userInfo, List<UserInfo> userInfoList) {
        baseMapper.insertSelective(userInfo);
        System.out.println(1 / 0);
        baseMapper.insertList(userInfoList);
    }
}
