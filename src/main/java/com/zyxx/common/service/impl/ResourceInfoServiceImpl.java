package com.zyxx.common.service.impl;

import com.zyxx.common.dao.ResourceInfoDao;
import com.zyxx.common.entity.ResourceInfo;
import com.zyxx.common.service.ResourceInfoService;
import com.zyxx.skeleton.core.base.service.impl.BaseServiceImpl;
import com.zyxx.skeleton.component.layui.LayuiTree;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源表 Service接口实现类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Service
public class ResourceInfoServiceImpl extends BaseServiceImpl<ResourceInfo, ResourceInfoDao> implements ResourceInfoService {

    @Override
    public List<LayuiTree> listResourceInfoByTree() {
        List<ResourceInfo> rootList = baseMapper.selectAll();
        return getRoot(rootList);
    }

    /**
     * 构建父级树
     *
     * @param rootList
     * @return
     */
    private List<LayuiTree> getRoot(List<ResourceInfo> rootList) {
        // 结果集
        List<LayuiTree> layuiTreeList = new ArrayList<>();
        // 根节点
        rootList.forEach(root -> {
            LayuiTree layuiTree;
            if (root.getPid() == 0) {
                layuiTree = new LayuiTree();
                layuiTree.setId(root.getId());
                layuiTree.setTitle(root.getName());
                layuiTree.setSpread(true);
                layuiTreeList.add(layuiTree);
            }
        });
        // 设置子节点
        layuiTreeList.forEach(child -> {
            child.setChildren(getChild(child.getId(), rootList));
        });
        return layuiTreeList;
    }

    /**
     * 构建子级树
     *
     * @param id
     * @param rootList
     * @return
     */
    private List<LayuiTree> getChild(int id, List<ResourceInfo> rootList) {
        // 子菜单结果集
        List<LayuiTree> childList = new ArrayList<>();
        // 一级子节点
        rootList.forEach(root -> {
            if (root.getPid() != 0) {
                LayuiTree layuiTree;
                if (root.getPid() == id) {
                    layuiTree = new LayuiTree();
                    layuiTree.setId(root.getId());
                    layuiTree.setTitle(root.getName());
                    layuiTree.setSpread(true);
                    childList.add(layuiTree);
                }
            }
        });
        // 二级子节点
        childList.forEach(child -> {
            child.setChildren(getChild(child.getId(), rootList));
        });
        return childList;
    }

    @Override
    public List<ResourceInfo> listResourceInfoByUserId(int userId) {
        return baseDao.listResourceInfoByUserId(userId);
    }

    @Override
    public List<ResourceInfo> listResourceInfoByRoleId(int roleId) {
        return baseDao.listResourceInfoByRoleId(roleId);
    }
}
