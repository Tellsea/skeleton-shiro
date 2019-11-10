package cn.tellsea.skeleton.core.dto;

import cn.tellsea.system.entity.ResourceInfo;
import cn.tellsea.system.entity.RoleInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * session 保存的用户角色权限信息
 *
 * @author: Tellsea
 * @date: 2019/09/11
 */
@Getter
@Setter
public class UserRoleResource {

    /**
     * 角色列表
     */
    List<RoleInfo> roleInfoList;

    /**
     * 权限列表
     */
    List<ResourceInfo> resourceInfoList;
}
