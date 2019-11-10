package cn.tellsea.system.dao;

import cn.tellsea.system.vo.UserInfoVo;
import cn.tellsea.skeleton.core.base.dao.BaseDao;
import cn.tellsea.system.entity.UserInfo;

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
