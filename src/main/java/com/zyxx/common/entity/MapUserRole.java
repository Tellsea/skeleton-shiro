package com.zyxx.common.entity;

import com.zyxx.skeleton.core.base.entity.BaseEntity;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户角色关联表 实体类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Data
public class MapUserRole extends BaseEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

}
