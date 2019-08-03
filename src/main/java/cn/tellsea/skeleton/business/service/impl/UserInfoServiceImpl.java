package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.entity.UserInfo;
import cn.tellsea.skeleton.business.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import cn.tellsea.skeleton.business.service.UserInfoService;
import org.springframework.stereotype.Service;
import cn.tellsea.skeleton.business.dao.UserInfoDao;

import java.util.List;

/**
 * 用户表 Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoByName(String username) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(username);
        List<UserInfo> list = userInfoMapper.select(userInfo);
        return list.size() == 0 ? null : list.get(0);
    }
}

