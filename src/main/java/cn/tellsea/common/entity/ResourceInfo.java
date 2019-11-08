package cn.tellsea.common.entity;

import cn.tellsea.skeleton.core.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 资源表 实体类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Getter
@Setter
public class ResourceInfo extends BaseEntity {

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
    private Integer pid;

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
    private Integer sort;

    /**
     * 是否叶子节点，0 否，1 是
     */
    private Boolean isLeaf;
}
