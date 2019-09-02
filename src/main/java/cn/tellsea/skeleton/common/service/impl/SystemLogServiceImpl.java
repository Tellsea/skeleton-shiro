package cn.tellsea.skeleton.common.service.impl;

import cn.tellsea.skeleton.common.dao.SystemLogDao;
import cn.tellsea.skeleton.common.entity.SystemLog;
import cn.tellsea.skeleton.common.service.SystemLogService;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
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
