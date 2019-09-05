package com.zyxx.skeleton.common.service.impl;

import com.zyxx.skeleton.common.dao.SystemLogDao;
import com.zyxx.skeleton.common.entity.SystemLog;
import com.zyxx.skeleton.common.service.SystemLogService;
import com.zyxx.skeleton.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 系统日志表 Service接口实现类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Service
public class SystemLogServiceImpl extends BaseServiceImpl<SystemLog, SystemLogDao> implements SystemLogService {

}
