package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.business.entity.UserRole;
import cn.tellsea.skeleton.business.service.UserRoleService;
import cn.tellsea.skeleton.business.service.UserService;
import cn.tellsea.skeleton.core.base.controller.BaseController;
import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.core.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User 控制层
 *
 * @author Tellsea
 * @Description Created on 2019/07/13
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    /**
     * 新增用户角色
     *
     * @return
     */
    @GetMapping("/insertUserRole")
    @ResponseBody
    public ResponseResult insertUserRole() {
        userRoleService.insert(new UserRole(1L, 5L));
        clearAllCache();
        return ResponseResult.success();
    }

    /**
     * 根据id查询用户角色
     *
     * @param id
     * @return
     */
    @GetMapping("/listUserRole/{id}")
    @ResponseBody
    public ResponseResult listUserRole(@PathVariable Long id) {
        return ResponseResult.success(userService.listUserRole(id));
    }
}
