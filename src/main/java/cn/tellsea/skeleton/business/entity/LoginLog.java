package cn.tellsea.skeleton.business.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类
 * 
 * @author Tellsea
 * @Description Created on 2019/07/16
 */
@Table(name = "login_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginLog implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * IP地址
     */
    @Column(name = "ip")
    private String ip;

    /**
     * 登录地点
     */
    @Column(name = "location")
    private String location;

    /**
     * 登录时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 登录设备
     */
    @Column(name = "device")
    private String device;
}