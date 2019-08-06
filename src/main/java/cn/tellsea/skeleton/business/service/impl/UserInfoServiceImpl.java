package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.dao.UserInfoDao;
import cn.tellsea.skeleton.business.entity.UserInfo;
import cn.tellsea.skeleton.business.service.UserInfoService;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import cn.tellsea.skeleton.core.global.exception.SkeletonException;
import org.springframework.stereotype.Service;

/**
* 用户表 Service接口实现类
*
* @author Tellsea
* @Description Created on 2019-08-06
*/
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, UserInfoDao> implements UserInfoService {

}
