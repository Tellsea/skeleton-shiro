package cn.tellsea.skeleton.common.service;

import cn.tellsea.skeleton.common.entity.RoleInfo;
import cn.tellsea.skeleton.core.base.service.BaseService;
import cn.tellsea.skeleton.core.layui.LayuiTable;

import java.util.List;

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

    /**
     * 根据用户 id 查询所有角色
     *
     * @param userId
     * @return
     */
    List<RoleInfo> listRoleInfoByUserId(int userId);
}
