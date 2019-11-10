package cn.tellsea.system.service;

import cn.tellsea.skeleton.component.layui.LayuiTable;
import cn.tellsea.skeleton.core.base.service.BaseService;
import cn.tellsea.system.entity.LoginLog;

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
