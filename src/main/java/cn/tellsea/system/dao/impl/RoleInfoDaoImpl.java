package cn.tellsea.system.dao.impl;

import cn.tellsea.skeleton.core.base.dao.impl.BaseDaoImpl;
import cn.tellsea.system.dao.RoleInfoDao;
import cn.tellsea.system.entity.RoleInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Repository
public class RoleInfoDaoImpl extends BaseDaoImpl<RoleInfo> implements RoleInfoDao {

    public List<RoleInfo> listRoleInfoByUserId(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select distinct ri.id,ri.`name`,ri.description from user_info as ui ");
        sql.append(" left join map_user_role as mur on ui.id = mur.user_id ");
        sql.append(" left join role_info as ri on mur.role_id = ri.id ");
        sql.append(" where ui.id = ? ");
        return jdbcTemplate.query(sql.toString(), new Object[]{userId}, new BeanPropertyRowMapper<>(RoleInfo.class));
    }
}
