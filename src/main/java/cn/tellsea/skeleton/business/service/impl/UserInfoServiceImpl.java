package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.SkeletonApplication;
import cn.tellsea.skeleton.business.entity.UserInfo;
import cn.tellsea.skeleton.business.service.UserInfoService;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import cn.tellsea.skeleton.core.global.exception.SkeletonException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户表 Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-06
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService {

    @Override
    @Transactional(rollbackFor = SkeletonException.class)
    public void test() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("张三");
        baseMapper.insert(userInfo);
        userInfo.setId(0);
        baseMapper.updateByPrimaryKey(userInfo);
        baseMapper.deleteByPrimaryKey(userInfo);
        baseMapper.selectByPrimaryKey(userInfo);
        List<UserInfo> userInfoList = new ArrayList<>();
        baseMapper.insertList(userInfoList);
    }
}
