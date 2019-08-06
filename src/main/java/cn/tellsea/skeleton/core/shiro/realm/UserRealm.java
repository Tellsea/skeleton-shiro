package cn.tellsea.skeleton.core.shiro.realm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 认证授权验证域
 *
 * @author Tellsea
 * @Description Created on 2019/7/13
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    /*@Autowired
    private UserInfoService userInfoService;*/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*log.info("授权用户：");
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
        return info;*/
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /*String username = (String) token.getPrincipal();
        log.info("认证用户：" + username);
        UserInfo userInfo = userInfoService.getUserInfoByName(username);
        if (userInfo == null) {
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getSalt()), getName());*/
        return null;
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
