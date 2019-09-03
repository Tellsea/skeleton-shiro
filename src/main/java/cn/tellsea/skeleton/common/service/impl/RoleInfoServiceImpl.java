package cn.tellsea.skeleton.common.service.impl;

import cn.tellsea.skeleton.common.dao.RoleInfoDao;
import cn.tellsea.skeleton.common.entity.RoleInfo;
import cn.tellsea.skeleton.common.service.RoleInfoService;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import cn.tellsea.skeleton.core.layui.LayuiTable;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色表 Service接口实现类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Service
public class RoleInfoServiceImpl extends BaseServiceImpl<RoleInfo, RoleInfoDao> implements RoleInfoService {

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
