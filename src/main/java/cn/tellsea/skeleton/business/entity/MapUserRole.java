package cn.tellsea.skeleton.business.entity;

import lombok.Data;

import javax.persistence.Id;

/**
 * 用户角色关联表 实体类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Data
public class MapUserRole {

    /**
     * 用户ID
     */
    @Id
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

}
