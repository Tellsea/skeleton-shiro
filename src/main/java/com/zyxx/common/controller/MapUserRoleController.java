package com.zyxx.common.controller;

import com.zyxx.common.entity.MapUserRole;
import com.zyxx.common.service.MapUserRoleService;
import com.zyxx.skeleton.core.base.controller.BaseController;
import com.zyxx.skeleton.core.global.dto.ResponseResult;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户角色关联表 前端控制器
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Controller
@RequestMapping("mapUserRole")
public class MapUserRoleController extends BaseController<MapUserRoleService> {

    @GetMapping("init")
    public String init() {
        return "admin/map_user_role";
    }

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
