package cn.tellsea.skeleton.common.service;

import cn.tellsea.skeleton.common.entity.LoginLog;
import cn.tellsea.skeleton.core.base.service.BaseService;
import cn.tellsea.skeleton.core.layui.LayuiTable;

/**
 * Service接口
 *
 * @author Tellsea
 * @date 2019-08-10
 */
public interface LoginLogService extends BaseService<LoginLog> {

    /**
     * 列表
     *
     * @param loginLog
     * @return
     */
    LayuiTable listLoginLog(LoginLog loginLog);
}
