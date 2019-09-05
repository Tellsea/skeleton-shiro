package com.zyxx.skeleton.core.shiro.filter;

import com.zyxx.skeleton.core.consts.SessionConst;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 访问控制器
 *
 * @author Tellsea
 * @date 2019/8/15
 * 参考文章：https://www.cnblogs.com/sprinkle/p/6823965.html
 */
public class UserInfoSessionFilter extends AccessControlFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        if (null != subject) {
            HttpSession session = WebUtils.toHttp(request).getSession();
            Object userInfoSession = session.getAttribute(SessionConst.USER_INFO_SESSION);
            if (null == userInfoSession) {
                // todo 查询用户信息保存在session
                System.out.println("卧槽，还没写，查询用户信息保存在session");
            }
        }
        return true;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        // 是否允许访问
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        // 拒绝访问
        return true;
    }
}
