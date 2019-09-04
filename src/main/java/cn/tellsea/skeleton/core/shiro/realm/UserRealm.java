package cn.tellsea.skeleton.core.shiro.realm;

import cn.tellsea.skeleton.common.entity.ResourceInfo;
import cn.tellsea.skeleton.common.entity.RoleInfo;
import cn.tellsea.skeleton.common.entity.UserInfo;
import cn.tellsea.skeleton.common.service.ResourceInfoService;
import cn.tellsea.skeleton.common.service.RoleInfoService;
import cn.tellsea.skeleton.common.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
    @Lazy
    @Autowired
    private RoleInfoService roleInfoService;
    @Lazy
    @Autowired
    private ResourceInfoService resourceInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserInfo user = (UserInfo) principalCollection.getPrimaryPrincipal();
        log.info("授权用户{}", user.getUserName());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<RoleInfo> roleInfoList = roleInfoService.listRoleInfoByUserId(user.getId());
        List<ResourceInfo> resourceInfoList = resourceInfoService.listResourceInfoByUserId(user.getId());
        if (!CollectionUtils.isEmpty(roleInfoList)) {
            roleInfoList.forEach(roleInfo -> info.addRole(roleInfo.getName()));
        }
        if (!CollectionUtils.isEmpty(resourceInfoList)) {
            resourceInfoList.forEach(resourceInfo -> info.addStringPermission(resourceInfo.getPerms()));
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        log.info("认证用户：{}", userName);
        UserInfo user = new UserInfo();
        user.setUserName(userName);
        UserInfo userInfo = userInfoService.selectOne(user);
        if (userInfo == null) {
            throw new UnknownAccountException();
        }
        // 防止泄露，shiro将SimpleAuthenticationInfo的第一个参数存入标签中
        user.setPassword("");
        user.setSalt("");
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
