package com.zyxx.skeleton.core.base.dao.impl;

import com.zyxx.skeleton.core.base.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 基类 Dao 实现类
 *
 * @author Tellsea
 * @date 2019/8/5
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

}
