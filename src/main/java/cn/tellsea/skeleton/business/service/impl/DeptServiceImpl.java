package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.mapper. DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import cn.tellsea.skeleton.business.service.DeptService;
import org.springframework.stereotype.Service;
import cn.tellsea.skeleton.business.dao.DeptDao;

/**
 * 部门表 Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;
    @Autowired
    private DeptMapper DeptMapper;

}

