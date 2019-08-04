package cn.tellsea.skeleton.business.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户表 实体类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Data
public class UserInfo {

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 账户，登录名，不可更改
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机
     */
    private String phone;

    /**
     * 性别 1男 2女
     */
    private Integer sex;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态 0 锁定 1有效
     */
    private Boolean status;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
