package cn.tellsea.skeleton.business.dao;

import cn.tellsea.skeleton.business.entity.vo.ResourceInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资源表 Dao 实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Repository
public class ResourceInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ResourceInfoVo> listResourceInfoByUserId(Integer id) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT DISTINCT re.id,re.`name`,re.parent_id,re.url,re.perms,re.type,re.icon,re.priority,re.create_time,re.`status` FROM user_info AS ui ");
        sql.append(" LEFT JOIN map_user_role AS mur ON ui.id = mur.user_id ");
        sql.append(" LEFT JOIN role_info AS ri ON mur.role_id = ri.id ");
        sql.append(" LEFT JOIN map_role_resource AS mrr ON ri.id = mrr.role_id ");
        sql.append(" LEFT JOIN resource_info AS re ON mrr.resource_id = re.id ");
        sql.append(" WHERE ui.id = ? ");
        return jdbcTemplate.query(sql.toString(), new Object[]{id}, new BeanPropertyRowMapper<>(ResourceInfoVo.class));
    }
}
