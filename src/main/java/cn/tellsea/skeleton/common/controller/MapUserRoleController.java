package cn.tellsea.skeleton.common.controller;

import cn.tellsea.skeleton.business.service.MapUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * 用户角色关联表 前端控制器
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Controller
@RequestMapping("mapUserRole")
public class MapUserRoleController {

    @Autowired
    private MapUserRoleService mapUserRoleService;

}
