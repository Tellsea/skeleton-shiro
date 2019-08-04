package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.dao.ResourceInfoDao;
import cn.tellsea.skeleton.business.entity.ResourceInfo;
import cn.tellsea.skeleton.business.entity.vo.ResourceInfoVo;
import cn.tellsea.skeleton.business.mapper.ResourceInfoMapper;
import cn.tellsea.skeleton.business.service.ResourceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    private ResourceInfoMapper resourceInfoMapper;

    @Override
    public List<ResourceInfoVo> listResourceInfoByUserId(Integer id) {
        List<ResourceInfoVo> list = resourceInfoDao.listResourceInfoByUserId(id);
        // 结果集
        List<ResourceInfoVo> resourceInfoVoList = new ArrayList<>();
        // 根节点
        list.forEach(root -> {
            if (root.getParentId() == 0 && root.getType() == 1) {
                resourceInfoVoList.add(root);
            }
        });
        // 设置子节点
        resourceInfoVoList.forEach(res -> {
            res.setChildMenus(getChild(res.getId(), list));
        });
        return resourceInfoVoList;
    }

    private List<ResourceInfoVo> getChild(Integer id, List<ResourceInfoVo> list) {
        // 子菜单结果集
        List<ResourceInfoVo> childList = new ArrayList<>();
        // 一级子节点
        list.forEach(res -> {
            if (res.getParentId() > 0 && res.getType() == 1) {
                if (res.getParentId().equals(id)) {
                    childList.add(res);
                }
            }
        });
        return childList;
    }
}

