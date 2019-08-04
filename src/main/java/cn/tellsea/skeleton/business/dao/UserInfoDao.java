package cn.tellsea.skeleton.business.dao;

import cn.tellsea.skeleton.business.entity.UserInfo;
import cn.tellsea.skeleton.business.entity.vo.UserInfoVo;
import cn.tellsea.skeleton.core.layui.LayuiPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表 Dao 实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Repository
public class UserInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserInfoVo> listUserInfo(UserInfo userInfo, LayuiPage layuiPage) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT ui.id,ui.user_name,ui.nick_name,ui.avatar,ui.phone,ui.sex,ui.description,ui.`status`,ui.create_user,ui.create_time,ui1.user_name AS create_user_name FROM user_info AS ui ");
        sql.append(" LEFT JOIN user_info AS ui1 ON ui.create_user = ui1.id ");
        sql.append(" WHERE 1 = 1 ");
        if (!StringUtils.isEmpty(userInfo.getUserName())) {
            sql.append(" AND ui.user_name LIKE '").append(userInfo.getUserName()).append("' ");
        }
        sql.append(" LIMIT ?,? ");
        return jdbcTemplate.query(sql.toString(), new Object[]{layuiPage.getOffset(), layuiPage.getLimit()}, new BeanPropertyRowMapper<>(UserInfoVo.class));
    }

    public int countUserInfo(UserInfo userInfo) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT count(ui.id) FROM user_info AS ui ");
        sql.append(" LEFT JOIN user_info AS ui1 ON ui.create_user = ui1.id ");
        sql.append(" WHERE 1 = 1 ");
        if (!StringUtils.isEmpty(userInfo.getUserName())) {
            sql.append(" AND ui.user_name LIKE '").append(userInfo.getUserName()).append("' ");
        }
        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }
}
