package com.zyxx.common.service;

import com.zyxx.common.entity.LoginLog;
import com.zyxx.skeleton.core.base.service.BaseService;
import com.zyxx.skeleton.core.layui.LayuiTable;

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
