package cn.tellsea.skeleton.business.service;

import cn.tellsea.skeleton.business.entity.LoginLog;

/**
 * Service接口
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
public interface LoginLogService {

    /**
     * 保存日志
     *
     * @param loginLog
     */
    void saveLoginLog(LoginLog loginLog);
}
