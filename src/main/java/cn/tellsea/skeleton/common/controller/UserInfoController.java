package cn.tellsea.skeleton.common.controller;

import cn.tellsea.skeleton.common.entity.UserInfo;
import cn.tellsea.skeleton.common.service.UserInfoService;
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
 * 用户表 前端控制器
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
 */
@Controller
@RequestMapping("userInfo")
public class UserInfoController extends BaseController<UserInfoService> {

    /**
     * 新增
     *
     * @param userInfo
     * @return
     */
    @PostMapping("saveUserInfo")
    @ResponseBody
    public ResponseResult saveUserInfo(UserInfo userInfo) {
        baseService.insertSelective(userInfo);
        return ResponseResult.build(StatusEnums.SAVE_SUCCESS);
    }

    /**
     * 更新
     *
     * @param userInfo
     * @return
     */
    @PostMapping("updateUserInfo")
    @ResponseBody
    public ResponseResult updateUserInfo(UserInfo userInfo) {
        baseService.updateByPrimaryKeySelective(userInfo);
        return ResponseResult.build(StatusEnums.UPDATE_SUCCESS);
    }

    @GetMapping("init")
    public String init() {
        return "admin/user_info";
    }

    /**
     * 列表
     *
     * @param userInfo
     * @return
     */
    @PostMapping("listUserInfo")
    @ResponseBody
    public LayuiTable listUserInfo(UserInfo userInfo) {
        return baseService.listUserInfo(userInfo);
    }
}
