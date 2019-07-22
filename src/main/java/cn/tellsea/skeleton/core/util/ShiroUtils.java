package cn.tellsea.skeleton.core.util;

import cn.tellsea.skeleton.core.shiro.realm.UserRealm;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

/**
 * Shiro 工具类
 *
 * @author Tellsea
 * @Description Created on 2019/7/19
 */
public class ShiroUtils {

    /**
     * 获得当前主体
     *
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获得当前Session
     *
     * @return
     */
    public static Session getSession() {
        return getSubject().getSession();
    }

    /**
     * 获得当前Session
     *
     * @param flag 是否自动创建session
     * @return
     */
    public static Session getSession(Boolean flag) {
        return getSubject().getSession(flag);
    }

    /**
     * 获得当前用户
     *
     * @return
     */
    public static Object getCurrentUser() {
        return getSubject().getPrincipal();
    }

    /**
     * 获得当前用户，以PrincipalCollection的形式
     *
     * @return
     */
    public static PrincipalCollection getPrincipals() {
        return getSubject().getPrincipals();
    }

    /**
     * 获得32位随机盐，可能包含字母、数字
     *
     * @return
     */
    public static String getRandomSalt() {
        return RandomStringUtils.random(32, true, true);
    }

    /**
     * 清除主体认证缓存
     *
     * @param principals
     */
    public static void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        getUserRealm().clearCachedAuthenticationInfo(principals);
    }

    /**
     * 清除主体授权缓存
     *
     * @param principals
     */
    public static void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        getUserRealm().clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除主体认证缓存、授权缓存
     */
    public static void claearCache(PrincipalCollection principals) {
        getUserRealm().clearCache(principals);
    }

    /**
     * 清除所有用户认证缓存
     *
     * @param principals
     */
    public static void clearAllCachedAuthenticationInfo() {
        getUserRealm().clearAllCachedAuthenticationInfo();
    }

    /**
     * 清除所有用户授权缓存
     *
     * @param principals
     */
    public static void clearAllCachedAuthorizationInfo() {
        getUserRealm().clearAllCachedAuthorizationInfo();
    }

    /**
     * 清除所有用户认证缓存、授权缓存
     */
    public static void claearAllCache() {
        getUserRealm().clearAllCache();
    }

    /**
     * 获得安全域
     *
     * @return
     */
    public static UserRealm getUserRealm() {
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        return (UserRealm) securityManager.getRealms().iterator().next();
    }
}