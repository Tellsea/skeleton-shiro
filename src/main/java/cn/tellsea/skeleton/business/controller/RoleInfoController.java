package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.business.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * 角色表 前端控制器
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Controller
@RequestMapping("roleInfo")
public class RoleInfoController {

    @Autowired
    private RoleInfoService roleInfoService;

}
