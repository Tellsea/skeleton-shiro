package cn.tellsea.skeleton.common.controller;

import cn.tellsea.skeleton.common.entity.MapUserRole;
import cn.tellsea.skeleton.common.service.MapUserRoleService;
import cn.tellsea.skeleton.core.base.controller.BaseController;
import cn.tellsea.skeleton.core.global.dto.ResponseResult;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 用户角色关联表 前端控制器
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
 */
@Controller
@RequestMapping("mapUserRole")
public class MapUserRoleController extends BaseController<MapUserRoleService> {

    /**
     * 新增
     *
     * @param mapUserRole
     * @return
     */
    @PostMapping("saveMapUserRole")
    @ResponseBody
    public ResponseResult saveMapUserRole(MapUserRole mapUserRole) {
        baseService.insertSelective(mapUserRole);
        return ResponseResult.build(StatusEnums.SAVE_SUCCESS);
    }

    /**
     * 更新
     *
     * @param mapUserRole
     * @return
     */
    @PostMapping("updateMapUserRole")
    @ResponseBody
    public ResponseResult updateMapUserRole(MapUserRole mapUserRole) {
        baseService.updateByPrimaryKeySelective(mapUserRole);
        return ResponseResult.build(StatusEnums.UPDATE_SUCCESS);
    }
}
