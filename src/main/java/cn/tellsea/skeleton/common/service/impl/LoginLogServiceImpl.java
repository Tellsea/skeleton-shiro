package cn.tellsea.skeleton.common.service.impl;

import cn.tellsea.skeleton.common.dao.LoginLogDao;
import cn.tellsea.skeleton.common.entity.LoginLog;
import cn.tellsea.skeleton.common.service.LoginLogService;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
 */
@Service
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLog, LoginLogDao> implements LoginLogService {

}
