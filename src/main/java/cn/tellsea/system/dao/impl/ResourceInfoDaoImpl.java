package cn.tellsea.system.dao.impl;

import cn.tellsea.system.dao.ResourceInfoDao;
import cn.tellsea.system.entity.ResourceInfo;
import cn.tellsea.skeleton.core.base.dao.impl.BaseDaoImpl;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资源表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Repository
public class ResourceInfoDaoImpl extends BaseDaoImpl<ResourceInfo> implements ResourceInfoDao {

    @Override
    public List<ResourceInfo> listResourceInfoByUserId(int userId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select distinct res.id,res.`name`,res.pid,res.url,res.perms,res.type,res.icon,res.sort,res.is_leaf from user_info as ui ");
        sql.append(" left join map_user_role as mur on ui.id = mur.user_id ");
        sql.append(" left join role_info as ri on mur.role_id = ri.id ");
        sql.append(" left join map_role_resource as mrr on ri.id = mrr.role_id ");
        sql.append(" left join resource_info as res on mrr.resource_id = res.id ");
        sql.append(" where ui.id = ? ");
        sql.append(" order by res.sort asc ");
        return jdbcTemplate.query(sql.toString(), new Object[]{userId}, new BeanPropertyRowMapper<>(ResourceInfo.class));
    }

    @Override
    public List<ResourceInfo> listResourceInfoByRoleId(int roleId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select res.id,res.`name`,res.pid,res.url,res.type,res.icon,res.sort,res.is_leaf from role_info as ri ");
        sql.append(" left join map_role_resource as mrr on ri.id = mrr.role_id ");
        sql.append(" left join resource_info as res on mrr.resource_id = res.id ");
        sql.append(" where ri.id = ? and res.is_leaf = 1 ");
        return jdbcTemplate.query(sql.toString(), new Object[]{roleId}, new BeanPropertyRowMapper<>(ResourceInfo.class));
    }
}
