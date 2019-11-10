package cn.tellsea.system.dao;

import cn.tellsea.system.entity.ResourceInfo;
import cn.tellsea.skeleton.core.base.dao.BaseDao;

import java.util.List;

/**
 * 资源表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-10-31
 */
public interface ResourceInfoDao extends BaseDao<ResourceInfo> {

    List<ResourceInfo> listResourceInfoByUserId(int userId);

    List<ResourceInfo> listResourceInfoByRoleId(int roleId);
}
