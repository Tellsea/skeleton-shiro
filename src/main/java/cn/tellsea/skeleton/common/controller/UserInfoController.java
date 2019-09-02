package cn.tellsea.skeleton.common.controller;

import cn.tellsea.skeleton.common.entity.UserInfo;
import cn.tellsea.skeleton.common.service.UserInfoService;
import cn.tellsea.skeleton.core.base.controller.BaseController;
import cn.tellsea.skeleton.core.global.dto.ResponseResult;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import cn.tellsea.skeleton.layui.LayuiTable;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户表 前端控制器
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
 */
@Api("用户管理")
@Controller
@RequestMapping("userInfo")
public class UserInfoController extends BaseController<UserInfoService> {

    @GetMapping("init")
    public String init() {
        return "admin/user_info";
    }

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

    @GetMapping("testTr")
    @ResponseBody
    public void testTr() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("test user 1");
        userInfo.setSalt("aaaaa");
        List<UserInfo> list = new ArrayList<>();
        list.add(userInfo);
        baseService.saveUserInfo(userInfo, list);
    }
}
