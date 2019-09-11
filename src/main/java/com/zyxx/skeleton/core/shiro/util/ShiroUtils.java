package com.zyxx.skeleton.core.shiro.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * Shiro 工具类
 *
 * @author Tellsea
 * @date 2019/7/19
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
     * 获得session保存的数据
     *
     * @param sessionKey
     * @return
     */
    public static Object getSessionAttribute(String sessionKey) {
        return getSession().getAttribute(sessionKey);
    }

    /**
     * 保存数据到session
     *
     * @param sessionKey
     * @return
     */
    public static void setSessionAttribute(String sessionKey, Object sessionValue) {
        getSession().setAttribute(sessionKey, sessionValue);
    }

    /**
     * 删除 session 数据
     *
     * @param sessionKey
     */
    public static void removeSessionAttribute(String sessionKey) {
        getSession().removeAttribute(sessionKey);
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

}
