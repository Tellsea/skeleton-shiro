package cn.tellsea.skeleton.business.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 资源表 实体类
 *
 * @author Tellsea
 * @Description Created on 2019-08-06
 */
@Data
public class ResourceInfo {

    /**
     * 资源编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * URL
     */
    private String url;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 1menu菜单，2button
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer priority;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 状态 0锁定 1有效
     */
    private Boolean status;

}
