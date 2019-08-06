package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.dao.SystemLogDao;
import cn.tellsea.skeleton.business.entity.SystemLog;
import cn.tellsea.skeleton.business.service.SystemLogService;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
* 系统日志表 Service接口实现类
*
* @author Tellsea
* @Description Created on 2019-08-06
*/
@Service
public class SystemLogServiceImpl extends BaseServiceImpl<SystemLog, SystemLogDao> implements SystemLogService {

}
