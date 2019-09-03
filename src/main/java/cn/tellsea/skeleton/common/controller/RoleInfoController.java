package cn.tellsea.skeleton.common.controller;

import cn.tellsea.skeleton.common.entity.RoleInfo;
import cn.tellsea.skeleton.common.service.RoleInfoService;
import cn.tellsea.skeleton.core.base.controller.BaseController;
import cn.tellsea.skeleton.core.global.dto.ResponseResult;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import cn.tellsea.skeleton.core.layui.LayuiTable;
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
    public ResponseResult updateRoleInfo(RoleInfo roleInfo) {
        baseService.updateByPrimaryKeySelective(roleInfo);
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
