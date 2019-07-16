package cn.tellsea.skeleton.business.entity;

import java.io.Serializable;
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
@Table(name = "role_resource")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleResource implements Serializable {
    /**
     * 角色ID
     */
    @Id
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 菜单/按钮ID
     */
    @Column(name = "resource_id")
    private Long resourceId;
}
