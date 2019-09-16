package com.zyxx.skeleton.necessary.service;

import com.zyxx.common.entity.UserInfo;

import java.util.List;

/**
 * 测试事物回滚 service
 *
 * @author: Tellsea
 * @date: 2019/09/16
 */
public interface TransactionService {

    /**
     * 保存用户信息（测试事物回滚）
     *
     * @param userInfo
     * @param userInfoList
     */
    void saveUserInfo(UserInfo userInfo, List<UserInfo> userInfoList);
}