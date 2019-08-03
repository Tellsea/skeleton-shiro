package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.mapper. MapUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import cn.tellsea.skeleton.business.service.MapUserRoleService;
import org.springframework.stereotype.Service;
import cn.tellsea.skeleton.business.dao.MapUserRoleDao;

/**
 * 用户角色关联表 Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Service
public class MapUserRoleServiceImpl implements MapUserRoleService {

    @Autowired
    private MapUserRoleDao mapUserRoleDao;
    @Autowired
    private MapUserRoleMapper MapUserRoleMapper;

}

