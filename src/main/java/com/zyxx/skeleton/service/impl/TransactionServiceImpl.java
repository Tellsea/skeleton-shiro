package com.zyxx.skeleton.service.impl;

import com.zyxx.common.entity.UserInfo;
import com.zyxx.common.mapper.UserInfoMapper;
import com.zyxx.skeleton.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试事物回滚 service 实现类
 *
 * @author: Tellsea
 * @date: 2019/09/16
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void saveUserInfo(UserInfo userInfo, List<UserInfo> userInfoList) {
        userInfoMapper.insertSelective(userInfo);
        System.out.println(1 / 0);
        userInfoMapper.insertList(userInfoList);
    }
}
