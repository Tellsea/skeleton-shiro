package com.zyxx.common.controller;

import com.zyxx.common.entity.RoleInfo;
import com.zyxx.common.service.RoleInfoService;
import com.zyxx.skeleton.core.base.controller.BaseController;
import com.zyxx.skeleton.core.dto.ResponseResult;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
import com.zyxx.skeleton.assembly.layui.LayuiTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 角色表 前端控制器
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Controller
@RequestMapping("roleInfo")
public class RoleInfoController extends BaseController<RoleInfoService> {

    @GetMapping("init")
    public String init() {
        return "admin/role_info";
    }

    /**
     * 新增
     *
     * @param roleInfo
     * @return
     */
    @PostMapping("saveRoleInfo")
    @ResponseBody
    public ResponseResult saveRoleInfo(RoleInfo roleInfo) {
        baseService.insertSelective(roleInfo);
        return ResponseResult.build(StatusEnums.SAVE_SUCCESS);
    }

    /**
     * 更新
     *
     * @param roleInfo
     * @return
     */
    @PostMapping("updateRoleInfo")
    @ResponseBody
    public ResponseResult updateRoleInfo(RoleInfo roleInfo, String resourceIds) {
        baseService.updateRoleInfo(roleInfo, resourceIds);
        return ResponseResult.build(StatusEnums.UPDATE_SUCCESS);
    }

    /**
     * 列表
     *
     * @param roleInfo
     * @return
     */
    @PostMapping("listRoleInfo")
    @ResponseBody
    public LayuiTable listRoleInfo(RoleInfo roleInfo) {
        return baseService.listRoleInfo(roleInfo);
    }
}
