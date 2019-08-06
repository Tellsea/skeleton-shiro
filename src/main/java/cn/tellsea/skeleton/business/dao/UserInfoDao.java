package cn.tellsea.skeleton.business.dao;

import cn.tellsea.skeleton.business.entity.UserInfo;
import cn.tellsea.skeleton.core.base.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表 Dao 实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-06
 */
@Repository
public class UserInfoDao extends BaseDao {

    public List<UserInfo> listUserInfo() {
        String sql = " select * from user_info ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserInfo.class));
    }
}
