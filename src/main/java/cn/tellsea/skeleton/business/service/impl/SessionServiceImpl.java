package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.dto.OnlineUser;
import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.business.service.SessionService;
import cn.tellsea.skeleton.core.common.dto.ResponseResult;
import cn.tellsea.skeleton.core.util.AddressUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 在线 session 管理 接口实现
 *
 * @author Tellsea
 * @Description Created on 2019/7/17
 */
@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionDAO sessionDAO;

    @Override
    public List<OnlineUser> getActiveSessions() {
        List<OnlineUser> list = new ArrayList<>();
        // 获取在线会话的集合
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for (Session session : sessions) {
            if (session != null) {
                OnlineUser onlineUser = new OnlineUser();
                SimplePrincipalCollection principalCollection;
                User user;
                //判断此session是否还在登录状态
                if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) == null) {
                    continue;
                } else {
                    //如果此session正在登录，将此session的数据放入principalCollection集合中，从而可获取登录用户对象数据
                    principalCollection = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                    user = (User) principalCollection.getPrimaryPrincipal();
                    onlineUser.setUid(user.getId().toString());
                    onlineUser.setUsername(user.getUsername());
                }
                onlineUser.setId(session.getId().toString());
                onlineUser.setHost(session.getHost());
                onlineUser.setAddress(AddressUtils.getAddress(session.getHost()));
                onlineUser.setStartTime(session.getStartTimestamp());
                onlineUser.setEndTime(session.getLastAccessTime());
                long timeout = session.getTimeout();
                onlineUser.setTimeout(timeout);
                // 0在线 1下线
                onlineUser.setStatus(timeout == 0L ? "0" : "1");
                list.add(onlineUser);
            }
        }
        return list;
    }

    @Override
    public ResponseResult forceLogout(String id) {
        Session session = sessionDAO.readSession(id);
        session.setTimeout(0L);
        session.stop();
        sessionDAO.delete(session);
        return ResponseResult.success();
    }
}
