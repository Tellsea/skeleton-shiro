package cn.tellsea.skeleton.common.service.impl;

import cn.tellsea.skeleton.common.dao.UserInfoDao;
import cn.tellsea.skeleton.common.entity.UserInfo;
import cn.tellsea.skeleton.common.vo.UserInfoVo;
import cn.tellsea.skeleton.common.service.UserInfoService;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import cn.tellsea.skeleton.core.layui.LayuiTable;
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
