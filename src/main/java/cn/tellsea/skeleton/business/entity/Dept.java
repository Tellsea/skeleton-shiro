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
@Table(name = "dept")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept implements Serializable {
    /**
     * 部门ID
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 上级部门ID
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 部门名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}