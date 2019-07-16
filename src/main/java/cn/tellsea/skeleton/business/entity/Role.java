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
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    /**
     * 角色ID
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 状态 0锁定 1有效
     */
    @Column(name = "status")
    private Boolean status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}