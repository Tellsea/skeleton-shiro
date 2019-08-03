package cn.tellsea.skeleton.business.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * 部门表 实体类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Data
public class Dept {

    /**
     * 部门ID
     */
    @Id
    private Integer id;

    /**
     * 上级部门ID
     */
    private Integer parentId;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
