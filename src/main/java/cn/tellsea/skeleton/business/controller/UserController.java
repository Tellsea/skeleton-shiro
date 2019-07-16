package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.business.service.UserService;
import cn.tellsea.skeleton.core.base.controller.BaseController;
import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.core.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User 控制层
 *
 * @author Tellsea
 * @Description Created on 2019/07/16
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @ResponseBody
    public Object list() {
        return baseService.selectAll();
    }

    /**
     * 获取当前session中的用户信息
     *
     * @return
     */
    @GetMapping("/getCurrentUser")
    @ResponseBody
    public ResponseResult getSessionUser() {
        return ResponseResult.success(super.getCurrentUser());
    }

    /**
     * 用户列表
     *
     * @return
     */
    @GetMapping("/listUser")
    @ResponseBody
    public ResponseResult listUser() {
        return ResponseResult.success(userService.listUser());
    }
}
