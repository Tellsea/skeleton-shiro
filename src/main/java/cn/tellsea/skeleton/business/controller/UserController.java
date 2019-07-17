package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.business.service.UserService;
import cn.tellsea.skeleton.core.base.controller.BaseController;
import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.core.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
     * 用户列表分页
     *
     * @param pn
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String index(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        model.addAttribute("pageInfo", userService.listUserByPage(pn));
        return "page/system/user/index";
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
     * 更新密码页
     *
     * @return
     */
    @GetMapping("/updatePwd")
    public String updatePwd() {
        return "page/personal/update-pwd";
    }

    /**
     * 个人信息
     *
     * @param session
     * @return
     */
    @GetMapping("/info")
    public String profile(HttpSession session) {
        User activeUser = super.getCurrentUser();
        if (activeUser == null) {
            return "page/login/login";
        }
        activeUser.setPassword(null);
        activeUser.setSalt(null);
        session.setAttribute("activeUser", activeUser);
        return "page/personal/info";
    }
}
