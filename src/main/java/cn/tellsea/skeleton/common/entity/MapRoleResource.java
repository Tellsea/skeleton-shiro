package cn.tellsea.skeleton.common.entity;

import cn.tellsea.skeleton.core.base.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Id;

/**
 * 角色资源关联表 实体类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Data
public class MapRoleResource extends BaseEntity {

    /**
     * 角色ID
     */
    @Id
    private Integer roleId;

    /**
     * 菜单/按钮ID
     */
    private Integer resourceId;

}
