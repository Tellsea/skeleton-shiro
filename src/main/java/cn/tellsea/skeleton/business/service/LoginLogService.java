package cn.tellsea.skeleton.business.service;

import cn.tellsea.skeleton.business.entity.LoginLog;
import cn.tellsea.skeleton.core.layui.LayuiPage;
import cn.tellsea.skeleton.core.layui.LayuiTable;

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

    /**
     * 列表
     *
     * @param loginLog
     * @param layuiPage
     * @return
     */
    LayuiTable listLoginLog(LoginLog loginLog, LayuiPage layuiPage);

}
