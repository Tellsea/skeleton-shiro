package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.core.base.controller.BaseController;
import cn.tellsea.skeleton.business.entity.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Role 控制层
 *
 * @author Tellsea
 * @Description Created on 2019/07/16
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController<Role> {

}
