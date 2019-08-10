package cn.tellsea.skeleton.common.service;

import cn.tellsea.skeleton.common.entity.RoleInfo;
import cn.tellsea.skeleton.core.base.service.BaseService;
import cn.tellsea.skeleton.core.layui.LayuiTable;

/**
 * 角色表 Service接口
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
 */
public interface RoleInfoService extends BaseService<RoleInfo> {

    /**
     * 列表
     *
     * @param roleInfo
     * @return
     */
    LayuiTable listRoleInfo(RoleInfo roleInfo);
}
