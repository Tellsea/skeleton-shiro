package com.zyxx.skeleton.core.shiro.realm;

import com.zyxx.common.entity.ResourceInfo;
import com.zyxx.common.entity.RoleInfo;
import com.zyxx.common.entity.UserInfo;
import com.zyxx.common.service.ResourceInfoService;
import com.zyxx.common.service.RoleInfoService;
import com.zyxx.common.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
public class ShiroRealm extends AuthorizingRealm {

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
        log.info("用户授权");
        UserInfo user = (UserInfo) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<RoleInfo> roleInfoList = roleInfoService.listRoleInfoByUserId(user.getId());
        List<ResourceInfo> resourceInfoList = resourceInfoService.listResourceInfoByUserId(user.getId());
        if (!CollectionUtils.isEmpty(roleInfoList)) {
            roleInfoList.forEach(roleInfo -> {
                if (!StringUtils.isEmpty(roleInfo.getName())) {
                    info.addRole(roleInfo.getName());
                }
            });
        }
        if (!CollectionUtils.isEmpty(resourceInfoList)) {
            resourceInfoList.forEach(resourceInfo -> {
                if (!StringUtils.isEmpty(resourceInfo.getPerms())) {
                    info.addStringPermission(resourceInfo.getPerms());
                }
            });
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("用户认证");
        String userName = (String) token.getPrincipal();
        UserInfo user = new UserInfo();
        user.setUserName(userName);
        UserInfo userInfo = userInfoService.selectOne(user);
        if (userInfo == null || 3 == userInfo.getStatus()) {
            throw new UnknownAccountException();
        }
        if (2 == userInfo.getStatus()) {
            throw new LockedAccountException();
        }
        // 防止泄露，shiro将SimpleAuthenticationInfo的第一个参数存入标签中
        user.setPassword("");
        user.setSalt("");
        return new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getSalt()), getName());
    }
}
