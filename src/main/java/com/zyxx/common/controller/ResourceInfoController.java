package com.zyxx.common.controller;

import com.zyxx.common.entity.ResourceInfo;
import com.zyxx.common.service.ResourceInfoService;
import com.zyxx.skeleton.core.shiro.aop.annotation.DynamicShiro;
import com.zyxx.skeleton.core.base.controller.BaseController;
import com.zyxx.skeleton.core.dto.ResponseResult;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 资源表 前端控制器
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Controller
@RequestMapping("resourceInfo")
public class ResourceInfoController extends BaseController<ResourceInfoService> {

    @GetMapping("init")
    public String init() {
        return "admin/resource_info";
    }

    /**
     * 新增
     *
     * @param resourceInfo
     * @return
     */
    @PostMapping("saveResourceInfo")
    @ResponseBody
    @DynamicShiro
    public ResponseResult saveResourceInfo(ResourceInfo resourceInfo) {
        baseService.insertSelective(resourceInfo);
        return ResponseResult.build(StatusEnums.SAVE_SUCCESS);
    }

    /**
     * 更新
     *
     * @param resourceInfo
     * @return
     */
    @PostMapping("updateResourceInfo")
    @ResponseBody
    @DynamicShiro
    public ResponseResult updateResourceInfo(ResourceInfo resourceInfo) {
        baseService.updateByPrimaryKeySelective(resourceInfo);
        return ResponseResult.build(StatusEnums.UPDATE_SUCCESS);
    }

    /**
     * 删除
     *
     * @param resourceInfo
     * @return
     */
    @PostMapping("deleteResourceInfo")
    @ResponseBody
    @DynamicShiro
    public ResponseResult deleteResourceInfo(ResourceInfo resourceInfo) {
        baseService.delete(resourceInfo);
        return ResponseResult.build(StatusEnums.DELETE_SUCCESS);
    }

    /**
     * 查询单条
     *
     * @param resourceInfo
     * @return
     */
    @PostMapping("getResourceInfo")
    @ResponseBody
    public ResponseResult getResourceInfo(ResourceInfo resourceInfo) {
        baseService.select(resourceInfo);
        return ResponseResult.build(StatusEnums.OK, baseService.selectOne(resourceInfo));
    }

    /**
     * 查询资源树
     *
     * @return
     */
    @GetMapping("listResourceInfoByTree")
    @ResponseBody
    public ResponseResult listResourceInfoByTree() {
        return ResponseResult.build(StatusEnums.OK, baseService.listResourceInfoByTree());
    }

    /**
     * 根据角色id查询所有资源，叶子
     *
     * @param roleId
     * @return
     */
    @PostMapping("listResourceInfoByRoleId")
    @ResponseBody
    public ResponseResult listResourceInfoByRoleId(int roleId) {
        return ResponseResult.build(StatusEnums.OK, baseService.listResourceInfoByRoleId(roleId));
    }
}
