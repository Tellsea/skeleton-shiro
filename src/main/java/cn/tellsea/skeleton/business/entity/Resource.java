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
@Table(name = "resource")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource implements Serializable {
    /**
     * 资源编号
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 资源名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 父级ID
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * URL
     */
    @Column(name = "url")
    private String url;

    /**
     * 类型：如button按钮 menu菜单
     */
    @Column(name = "type")
    private String type;

    /**
     * 菜单图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 排序
     */
    @Column(name = "priority")
    private Long priority;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 状态 0锁定 1有效
     */
    @Column(name = "status")
    private Boolean status;

    /**
     * 权限标识
     */
    @Column(name = "perms")
    private String perms;
}