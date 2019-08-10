package cn.tellsea.skeleton.common.controller;

import cn.tellsea.skeleton.common.entity.MapRoleResource;
import cn.tellsea.skeleton.common.service.MapRoleResourceService;
import cn.tellsea.skeleton.core.base.controller.BaseController;
import cn.tellsea.skeleton.core.global.dto.ResponseResult;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 角色资源关联表 前端控制器
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
 */
@Controller
@RequestMapping("mapRoleResource")
public class MapRoleResourceController extends BaseController<MapRoleResourceService> {

    /**
     * 新增
     *
     * @param mapRoleResource
     * @return
     */
    @PostMapping("saveMapRoleResource")
    @ResponseBody
    public ResponseResult saveMapRoleResource(MapRoleResource mapRoleResource) {
        baseService.insertSelective(mapRoleResource);
        return ResponseResult.build(StatusEnums.SAVE_SUCCESS);
    }

    /**
     * 更新
     *
     * @param mapRoleResource
     * @return
     */
    @PostMapping("updateMapRoleResource")
    @ResponseBody
    public ResponseResult updateMapRoleResource(MapRoleResource mapRoleResource) {
        baseService.updateByPrimaryKeySelective(mapRoleResource);
        return ResponseResult.build(StatusEnums.UPDATE_SUCCESS);
    }
}
