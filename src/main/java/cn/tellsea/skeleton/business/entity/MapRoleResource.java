package cn.tellsea.skeleton.business.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * 角色资源关联表 实体类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Data
public class MapRoleResource {

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单/按钮ID
     */
    private Integer resourceId;

}
