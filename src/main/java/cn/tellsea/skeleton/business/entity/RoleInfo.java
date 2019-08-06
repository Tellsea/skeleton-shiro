package cn.tellsea.skeleton.business.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 角色表 实体类
 *
 * @author Tellsea
 * @Description Created on 2019-08-06
 */
@Data
public class RoleInfo {

    /**
     * 角色ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态 0锁定 1有效
     */
    private Boolean status;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
