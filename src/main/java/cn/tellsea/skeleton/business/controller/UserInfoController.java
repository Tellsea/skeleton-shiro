package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.business.entity.UserInfo;
import cn.tellsea.skeleton.business.entity.vo.UserInfoVo;
import cn.tellsea.skeleton.business.service.UserInfoService;
import cn.tellsea.skeleton.core.global.dto.ResponseResult;
import cn.tellsea.skeleton.core.layui.LayuiPage;
import cn.tellsea.skeleton.core.layui.LayuiTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户表 前端控制器
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Controller
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("init")
    public String init() {
        return "admin/user_info";
    }

    /**
     * 数据列表
     *
     * @param layuiPage
     * @param userInfo
     * @return
     */
    @PostMapping("listUserInfo")
    @ResponseBody
    public LayuiTable listUserInfo(LayuiPage layuiPage, UserInfo userInfo) {
        int count = userInfoService.countUserInfo(userInfo);
        List<UserInfoVo> list = null;
        if (count > 0) {
            list = userInfoService.listUserInfo(userInfo, layuiPage);
        }
        return LayuiTable.build(count, list);
    }
}
