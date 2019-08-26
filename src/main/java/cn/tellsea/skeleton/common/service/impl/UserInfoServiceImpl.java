package cn.tellsea.skeleton.common.service.impl;

import cn.tellsea.skeleton.common.dao.UserInfoDao;
import cn.tellsea.skeleton.common.entity.UserInfo;
import cn.tellsea.skeleton.common.entity.vo.UserInfoVO;
import cn.tellsea.skeleton.common.service.UserInfoService;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import cn.tellsea.skeleton.core.global.exception.GlobalException;
import cn.tellsea.skeleton.core.layui.LayuiTable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户表 Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, UserInfoDao> implements UserInfoService {

    @Override
    public LayuiTable listUserInfo(UserInfo userInfo) {
        // todo 不能模糊查询
        int count = baseMapper.selectCount(userInfo);
        List<UserInfoVO> list = null;
        if (0 < count) {
            list = baseDao.listUserInfo(userInfo);
        }
        return LayuiTable.build(count, list);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveUserInfo(UserInfo userInfo, List<UserInfo> userInfoList) {
        baseMapper.insertSelective(userInfo);
        // System.out.println(1 / 0);
        if (1 == 1) {
            throw new GlobalException(StatusEnums.SAVE_ERROR);
        }
        baseMapper.insertList(userInfoList);
    }
}
