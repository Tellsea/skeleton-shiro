package cn.tellsea.system.service;

import cn.tellsea.skeleton.component.layui.LayuiTable;
import cn.tellsea.skeleton.core.base.service.BaseService;
import cn.tellsea.system.entity.RoleInfo;

import java.util.List;

/**
 * 角色表 Service接口
 *
 * @author Tellsea
 * @date 2019-08-10
 */
public interface RoleInfoService extends BaseService<RoleInfo> {

    /**
     * 更新角色以及区权限
     *
     * @param roleInfo
     * @param resourceIds
     */
    void updateRoleInfo(RoleInfo roleInfo, String resourceIds);

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
