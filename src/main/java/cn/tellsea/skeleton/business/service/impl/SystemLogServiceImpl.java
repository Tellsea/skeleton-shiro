package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.mapper. SystemLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import cn.tellsea.skeleton.business.service.SystemLogService;
import org.springframework.stereotype.Service;
import cn.tellsea.skeleton.business.dao.SystemLogDao;

/**
 * 系统日志表 Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    private SystemLogDao systemLogDao;
    @Autowired
    private SystemLogMapper SystemLogMapper;

}

