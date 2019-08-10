package cn.tellsea.skeleton.common.controller;

import cn.tellsea.skeleton.common.entity.ResourceInfo;
import cn.tellsea.skeleton.common.service.ResourceInfoService;
import cn.tellsea.skeleton.core.base.controller.BaseController;
import cn.tellsea.skeleton.core.global.dto.ResponseResult;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 资源表 前端控制器
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
 */
@Controller
@RequestMapping("resourceInfo")
public class ResourceInfoController extends BaseController<ResourceInfoService> {

    /**
     * 新增
     *
     * @param resourceInfo
     * @return
     */
    @PostMapping("saveResourceInfo")
    @ResponseBody
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
    public ResponseResult updateResourceInfo(ResourceInfo resourceInfo) {
        baseService.updateByPrimaryKeySelective(resourceInfo);
        return ResponseResult.build(StatusEnums.UPDATE_SUCCESS);
    }
}
