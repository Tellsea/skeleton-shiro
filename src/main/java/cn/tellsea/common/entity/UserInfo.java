package cn.tellsea.common.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.tellsea.skeleton.core.base.entity.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户表 实体类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Getter
@Setter
public class UserInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6743567631108323096L;

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Excel(name = "id")
    private Integer id;

    /**
     * 用户名
     */
    @Excel(name = "用户名")
    private String userName;

    /**
     * 昵称
     */
    @Excel(name = "昵称")
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
    @Excel(name = "性别", replace = {"男_1", "女_2"})
    private Integer sex;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 状态 0 锁定 1有效 2 删除
     */
    private Integer status;
}
