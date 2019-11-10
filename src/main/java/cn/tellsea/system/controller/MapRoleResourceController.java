package cn.tellsea.system.controller;

import cn.tellsea.skeleton.core.dto.ResponseResult;
import cn.tellsea.system.entity.MapRoleResource;
import cn.tellsea.system.service.MapRoleResourceService;
import cn.tellsea.skeleton.core.base.controller.BaseController;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 角色资源关联表 前端控制器
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Controller
@RequestMapping("mapRoleResource")
public class MapRoleResourceController extends BaseController<MapRoleResourceService> {

    @GetMapping("init")
    public String init() {
        return "admin/map_role_resource";
    }

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
