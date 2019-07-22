package cn.tellsea.skeleton.core.shiro.realm;

import cn.tellsea.skeleton.business.entity.Resource;
import cn.tellsea.skeleton.business.entity.Role;
import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.business.service.ResourceService;
import cn.tellsea.skeleton.business.service.RoleService;
import cn.tellsea.skeleton.business.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 认证授权验证域
 *
 * @author Tellsea
 * @Description Created on 2019/7/13
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("授权用户：");
        User user = (User) principalCollection.getPrimaryPrincipal();
        // 查找角色和权限
        List<Role> roleList = roleService.listRoleByUserId(user.getId());
        List<Resource> resourceList = resourceService.listResourceByUserId(user.getId());
        // 授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (null == roleList || roleList.size() == 0) {
            roleList.forEach(role -> info.addRole(role.getName()));
        }
        if (null == resourceList || resourceList.size() == 0) {
            resourceList.forEach(resource -> info.addStringPermission(resource.getName()));
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        log.info("认证用户：" + username);
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
