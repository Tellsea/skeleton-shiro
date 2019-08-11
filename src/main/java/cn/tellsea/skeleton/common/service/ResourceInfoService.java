package cn.tellsea.skeleton.common.service;

import cn.tellsea.skeleton.common.entity.ResourceInfo;
import cn.tellsea.skeleton.core.base.service.BaseService;
import cn.tellsea.skeleton.core.layui.LayuiTree;

import java.util.List;

/**
 * 资源表 Service接口
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
 */
public interface ResourceInfoService extends BaseService<ResourceInfo> {

    /**
     * 资源树结构
     *
     * @return
     */
    List<LayuiTree> listResourceInfoByTree();

    /**
     * 根据用户id查询所有资源
     *
     * @param userId
     * @return
     */
    List<ResourceInfo> listResourceInfoByUserId(int userId);

    /**
     * 根据角色id查询所有资源
     *
     * @param roleId
     * @return
     */
    List<ResourceInfo> listResourceInfoByRoleId(int roleId);
}
