package cn.tellsea.skeleton.core.shiro.realm;

import cn.tellsea.skeleton.common.entity.UserInfo;
import cn.tellsea.skeleton.common.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * 认证授权验证域
 *
 * @author Tellsea
 * @date 2019/7/13
 * Shiro 事物失效问题：https://blog.csdn.net/finalcola/article/details/81197584
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    /**
     * 在Realm中Service声明上加入@Lazy注解，延迟Realm实现中Service对象的初始化时间，
     * 这样就可以保证Service实际初始化的时候会被BeanPostProcessor拦截，创建具有事务功能的代理对象
     */
    @Lazy
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("授权用户：");
        /*User user = (User) principalCollection.getPrimaryPrincipal();
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
        String username = (String) token.getPrincipal();
        log.info("认证用户：" + username);
        UserInfo user = new UserInfo();
        user.setUserName(username);
        UserInfo userInfo = userInfoService.selectOne(user);
        if (userInfo == null) {
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getSalt()), getName());
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
