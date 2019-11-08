package cn.tellsea.common.service.impl;

import cn.tellsea.common.dao.impl.MapUserRoleDaoImpl;
import cn.tellsea.common.entity.MapUserRole;
import cn.tellsea.common.service.MapUserRoleService;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户角色关联表 Service接口实现类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Service
public class MapUserRoleServiceImpl extends BaseServiceImpl<MapUserRole, MapUserRoleDaoImpl> implements MapUserRoleService {

}
