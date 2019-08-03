package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.mapper. ResourceInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import cn.tellsea.skeleton.business.service.ResourceInfoService;
import org.springframework.stereotype.Service;
import cn.tellsea.skeleton.business.dao.ResourceInfoDao;

/**
 * 资源表 Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Service
public class ResourceInfoServiceImpl implements ResourceInfoService {

    @Autowired
    private ResourceInfoDao resourceInfoDao;
    @Autowired
    private ResourceInfoMapper ResourceInfoMapper;

}

