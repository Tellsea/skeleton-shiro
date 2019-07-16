package cn.tellsea.skeleton.core.base.controller;

import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.core.base.service.BaseService;
import cn.tellsea.skeleton.core.shiro.realm.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 基类控制器
 *
 * @param <T> 不能为空
 * @author Tellsea
 * @Description Created on 2019/7/13
 */
public class BaseController<T> {

    @Autowired
    protected BaseService<T> baseService;

    protected static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    protected Session getSession() {
        return getSubject().getSession();
    }

    protected Session getSession(Boolean flag) {
        return getSubject().getSession(flag);
    }

    protected User getCurrentUser() {
        return (User) getSubject().getPrincipal();
    }

    /**
     * 清除所有的 认证缓存 和 授权缓存
     */
    public void clearAllCache() {
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        UserRealm userRealm = (UserRealm) securityManager.getRealms().iterator().next();
        userRealm.clearAllCache();
    }
}
