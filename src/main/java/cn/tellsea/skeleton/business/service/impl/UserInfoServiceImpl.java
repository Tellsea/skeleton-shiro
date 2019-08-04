package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.entity.UserInfo;
import cn.tellsea.skeleton.business.entity.vo.UserInfoVo;
import cn.tellsea.skeleton.business.mapper.UserInfoMapper;
import cn.tellsea.skeleton.core.layui.LayuiPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import cn.tellsea.skeleton.business.service.UserInfoService;
import org.springframework.stereotype.Service;
import cn.tellsea.skeleton.business.dao.UserInfoDao;
import tk.mybatis.mapper.entity.Example;

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

    @Override
    public List<UserInfoVo> listUserInfo(UserInfo userInfo, LayuiPage layuiPage) {
        return userInfoDao.listUserInfo(userInfo, layuiPage);
    }

    @Override
    public int countUserInfo(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(userInfo.getUserName())) {
            criteria.andLike("user_name", userInfo.getUserName());
        }
        return userInfoMapper.selectCountByExample(example);
    }
}

