package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.business.entity.ResourceInfo;
import cn.tellsea.skeleton.business.entity.UserInfo;
import cn.tellsea.skeleton.business.service.ResourceInfoService;
import cn.tellsea.skeleton.business.service.UserInfoService;
import cn.tellsea.skeleton.core.global.dto.ResponseResult;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import cn.tellsea.skeleton.core.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 跳转 控制器
 * @author Tellsea
 * @Description Created on 2019/8/4
 */
@Controller
public class IndexController {

    @Autowired
    private ResourceInfoService resourceInfoService;

    @GetMapping("")
    public String index(Model model) {
        UserInfo userInfo = (UserInfo) ShiroUtils.getCurrentUser();
        if (null == userInfo) {
            return "admin/login";
        }
        model.addAttribute("resourceInfoList", resourceInfoService.listResourceInfoByUserId(userInfo.getId()));
        return "admin/index";
    }

    @GetMapping("json")
    @ResponseBody
    public ResponseResult json() {
        UserInfo userInfo = (UserInfo) ShiroUtils.getCurrentUser();
        return ResponseResult.build(StatusEnums.SUCCESS, resourceInfoService.listResourceInfoByUserId(userInfo.getId()));
    }
}
