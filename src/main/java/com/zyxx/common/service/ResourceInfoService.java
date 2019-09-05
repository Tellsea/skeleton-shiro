package com.zyxx.common.service;

import com.zyxx.common.entity.ResourceInfo;
import com.zyxx.skeleton.core.base.service.BaseService;
import com.zyxx.skeleton.core.layui.LayuiTree;

import java.util.List;

/**
 * 资源表 Service接口
 *
 * @author Tellsea
 * @date 2019-08-10
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
     * 根据角色id查询所有资源，叶子
     *
     * @param roleId
     * @return
     */
    List<ResourceInfo> listResourceInfoByRoleId(int roleId);
}
