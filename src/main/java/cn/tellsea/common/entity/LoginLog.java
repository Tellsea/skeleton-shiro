package cn.tellsea.common.entity;

import cn.tellsea.skeleton.core.base.entity.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 *  实体类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Getter
@Setter
public class LoginLog extends BaseEntity {

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 登录地点
     */
    private String location;

    /**
     * 登录时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 登录设备
     */
    private String device;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;
}
