package cn.tellsea.skeleton.business.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 角色资源关联表 Dao 实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Repository
public class MapRoleResourceDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

}
