package cn.tellsea.skeleton.common.service.impl;

import cn.tellsea.skeleton.common.dao.RoleInfoDao;
import cn.tellsea.skeleton.common.entity.MapRoleResource;
import cn.tellsea.skeleton.common.entity.RoleInfo;
import cn.tellsea.skeleton.common.mapper.MapRoleResourceMapper;
import cn.tellsea.skeleton.common.service.RoleInfoService;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import cn.tellsea.skeleton.core.global.exception.GlobalException;
import cn.tellsea.skeleton.core.layui.LayuiTable;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色表 Service接口实现类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Service
public class RoleInfoServiceImpl extends BaseServiceImpl<RoleInfo, RoleInfoDao> implements RoleInfoService {

    @Autowired
    private MapRoleResourceMapper mapRoleResourceMapper;

    @Override
    public void updateRoleInfo(RoleInfo roleInfo, String resourceIds) {
        int count = baseMapper.updateByPrimaryKeySelective(roleInfo);
        if (1 != count) {
            throw new GlobalException(StatusEnums.UPDATE_ERROR);
        }
        MapRoleResource del = new MapRoleResource();
        del.setRoleId(roleInfo.getId());
        mapRoleResourceMapper.delete(del);
        String[] split = resourceIds.split(",");
        if (0 != split.length) {
            List<MapRoleResource> list = new ArrayList<>();
            MapRoleResource mapRoleResource = null;
            for (int i = 0; i < split.length; i++) {
                mapRoleResource = new MapRoleResource();
                mapRoleResource.setRoleId(roleInfo.getId());
                mapRoleResource.setResourceId(Integer.valueOf(split[i]));
                list.add(mapRoleResource);
            }
            mapRoleResourceMapper.insertList(list);
        }
    }

    @Override
    public LayuiTable listRoleInfo(RoleInfo roleInfo) {
        int count = baseMapper.selectCount(roleInfo);
        List<RoleInfo> list = null;
        if (0 < count) {
            PageHelper.startPage(roleInfo.getPage(), roleInfo.getLimit());
            list = new PageInfo<>(baseMapper.select(roleInfo)).getList();
        }
        return LayuiTable.build(count, list);
    }

    @Override
    public List<RoleInfo> listRoleInfoByUserId(int userId) {
        return baseDao.listRoleInfoByUserId(userId);
    }
}
