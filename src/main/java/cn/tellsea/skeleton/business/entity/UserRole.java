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
@Table(name = "user_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 角色ID
     */
    @Id
    @Column(name = "role_id")
    private Long roleId;
}