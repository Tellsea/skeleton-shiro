package com.zyxx.common.dao;

import com.zyxx.common.entity.RoleInfo;
import com.zyxx.skeleton.core.base.dao.BaseDao;
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
public class RoleInfoDao extends BaseDao {

    public List<RoleInfo> listRoleInfoByUserId(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select distinct ri.id,ri.`name`,ri.description from user_info as ui ");
        sql.append(" left join map_user_role as mur on ui.id = mur.user_id ");
        sql.append(" left join role_info as ri on mur.role_id = ri.id ");
        sql.append(" where ui.id = ? ");
        return jdbcTemplate.query(sql.toString(), new Object[]{userId}, new BeanPropertyRowMapper<>(RoleInfo.class));
    }
}
