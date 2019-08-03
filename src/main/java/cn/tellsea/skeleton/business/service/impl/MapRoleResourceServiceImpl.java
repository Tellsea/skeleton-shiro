package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.mapper. MapRoleResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import cn.tellsea.skeleton.business.service.MapRoleResourceService;
import org.springframework.stereotype.Service;
import cn.tellsea.skeleton.business.dao.MapRoleResourceDao;

/**
 * 角色资源关联表 Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Service
public class MapRoleResourceServiceImpl implements MapRoleResourceService {

    @Autowired
    private MapRoleResourceDao mapRoleResourceDao;
    @Autowired
    private MapRoleResourceMapper mapRoleResourceMapper;

}

