package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.mapper. RoleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import cn.tellsea.skeleton.business.service.RoleInfoService;
import org.springframework.stereotype.Service;
import cn.tellsea.skeleton.business.dao.RoleInfoDao;

/**
 * 角色表 Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoDao roleInfoDao;
    @Autowired
    private RoleInfoMapper roleInfoMapper;

}

