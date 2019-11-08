package cn.tellsea.common.dao.impl;

import cn.tellsea.common.dao.UserInfoDao;
import cn.tellsea.common.entity.UserInfo;
import cn.tellsea.common.vo.UserInfoVo;
import cn.tellsea.skeleton.core.base.dao.impl.BaseDaoImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表 Dao 实现类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Repository
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao {

    @Override
    public List<UserInfoVo> listUserInfo(UserInfo userInfo) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select ui.id,ui.user_name,ui.nick_name,ui.`password`,ui.salt,ui.avatar,ui.phone,ui.sex,ui.description,ui.`status`,ui.create_user,ui.create_time,ui1.user_name create_user_name from user_info as ui ");
        sql.append(" left join user_info as ui1 on ui.create_user = ui1.id ");
        sql.append(" where ui.`status` <> 3 ");
        if (!StringUtils.isEmpty(userInfo.getUserName())) {
            sql.append(" and ui.user_name like '%").append(userInfo.getUserName()).append("%'");
        }
        sql.append(" limit ?,? ");
        return jdbcTemplate.query(sql.toString(), new Object[]{userInfo.getPage(), userInfo.getLimit()}, new BeanPropertyRowMapper<>(UserInfoVo.class));
    }
}
