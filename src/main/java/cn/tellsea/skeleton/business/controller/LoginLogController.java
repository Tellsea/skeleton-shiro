package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.business.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 *  前端控制器
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Controller
@RequestMapping("loginLog")
public class LoginLogController {

    @Autowired
    private LoginLogService loginLogService;

}
