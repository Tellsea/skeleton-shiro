package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.mapper. LoginLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import cn.tellsea.skeleton.business.service.LoginLogService;
import org.springframework.stereotype.Service;
import cn.tellsea.skeleton.business.dao.LoginLogDao;

/**
 *  Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogDao loginLogDao;
    @Autowired
    private LoginLogMapper LoginLogMapper;

}

