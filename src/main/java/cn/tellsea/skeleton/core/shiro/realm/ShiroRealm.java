package cn.tellsea.skeleton.core.shiro.realm;

import cn.tellsea.skeleton.core.dto.UserRoleResource;
import cn.tellsea.skeleton.core.shiro.util.ShiroUtils;
import cn.tellsea.system.entity.ResourceInfo;
import cn.tellsea.system.entity.RoleInfo;
import cn.tellsea.system.entity.UserInfo;
import cn.tellsea.system.service.ResourceInfoService;
import cn.tellsea.system.service.RoleInfoService;
import cn.tellsea.system.service.UserInfoService;
import cn.tellsea.skeleton.core.consts.SessionConst;
import cn.tellsea.skeleton.core.consts.UserInfoStatus;
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
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        UserRoleResource urr = (UserRoleResource) ShiroUtils.getSessionAttribute(SessionConst.USER_ROLE_RESOURCE);
        List<RoleInfo> roleInfoList;
        List<ResourceInfo> resourceInfoList;
        if (null != urr) {
            roleInfoList = urr.getRoleInfoList();
            resourceInfoList = urr.getResourceInfoList();
        } else {
            // 如果当前操作为记住我之后，后台又重启了，则前端产生一个问题，当前用户已经登录，但是后台 session 被清空，所以这里需要判断重新加载权限信息
            UserInfo user = (UserInfo) principalCollection.getPrimaryPrincipal();
            roleInfoList = roleInfoService.listRoleInfoByUserId(user.getId());
            resourceInfoList = resourceInfoService.listResourceInfoByUserId(user.getId());
        }
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
        String userName = (String) token.getPrincipal();
        UserInfo user = new UserInfo();
        user.setUserName(userName);
        UserInfo userInfo = userInfoService.selectOne(user);
        if (userInfo == null || UserInfoStatus.DELETE == userInfo.getStatus()) {
            throw new UnknownAccountException();
        }
        if (UserInfoStatus.LOCKING == userInfo.getStatus()) {
            throw new LockedAccountException();
        }
        // 防止泄露，shiro将SimpleAuthenticationInfo的第一个参数存入标签中
        user.setPassword("");
        user.setSalt("");
        return new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getSalt()), getName());
    }

    @Override
    public AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        // 获得当前用户的信息，底层会从先尝试从缓存中取，若不存在会执行 doGetAuthorizationInfo 方法，并写入缓存中
        return super.getAuthorizationInfo(principals);
    }
}
