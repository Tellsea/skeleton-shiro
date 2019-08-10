package cn.tellsea.skeleton.common.entity;

import cn.tellsea.skeleton.core.base.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Id;

/**
 * 用户角色关联表 实体类
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
 */
@Data
public class MapUserRole extends BaseEntity {

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
