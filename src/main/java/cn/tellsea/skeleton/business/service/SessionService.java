package cn.tellsea.skeleton.business.service;

import cn.tellsea.skeleton.business.dto.OnlineUser;
import cn.tellsea.skeleton.core.common.dto.ResponseResult;

import java.util.List;

/**
 * 在线 session 管理 接口层
 *
 * @author Tellsea
 * @Description Created on 2019/7/17
 */
public interface SessionService {

    /**
     * 获得所有在线session
     *
     * @return
     */
    List<OnlineUser> getActiveSessions();

    /**
     * 下线某个session
     *
     * @param id
     * @return
     */
    ResponseResult forceLogout(String id);
}
