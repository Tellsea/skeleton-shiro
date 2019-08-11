package cn.tellsea.skeleton.common.dao;

import cn.tellsea.skeleton.common.entity.RoleInfo;
import cn.tellsea.skeleton.core.base.dao.BaseDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色表 Dao 实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
 */
@Repository
public class RoleInfoDao extends BaseDao {

    public List<RoleInfo> listRoleInfoByUserId(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select ri.id,ri.`name`,ri.description from user_info as ui ");
        sql.append(" left join map_user_role as mur on ui.id = mur.user_id ");
        sql.append(" left join role_info as ri on mur.role_id = ri.id ");
        sql.append(" where ui.id = ? ");
        return jdbcTemplate.query(sql.toString(), new Object[]{userId}, new BeanPropertyRowMapper<>(RoleInfo.class));
    }
}
