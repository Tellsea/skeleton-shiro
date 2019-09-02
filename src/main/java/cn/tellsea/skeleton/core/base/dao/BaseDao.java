package cn.tellsea.skeleton.core.base.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 基类 Dao 实现类
 *
 * @author Tellsea
 * @date 2019/8/5
 */
public class BaseDao {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

}
