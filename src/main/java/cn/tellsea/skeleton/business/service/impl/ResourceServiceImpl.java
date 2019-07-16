package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.entity.Resource;
import cn.tellsea.skeleton.business.mapper.ResourceMapper;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import cn.tellsea.skeleton.business.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Resource 接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019/07/16
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> listResourceByUserId(Long id) {
        return resourceMapper.listResourceByUserId(id);
    }
}
