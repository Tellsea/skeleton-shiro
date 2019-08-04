package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.business.entity.LoginLog;
import cn.tellsea.skeleton.business.service.LoginLogService;
import cn.tellsea.skeleton.core.layui.LayuiPage;
import cn.tellsea.skeleton.core.layui.LayuiTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 前端控制器
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Controller
@RequestMapping("loginLog")
public class LoginLogController {

    @Autowired
    private LoginLogService loginLogService;

    @GetMapping("init")
    public String init() {
        return "admin/login_log";
    }

    /**
     * 列表
     *
     * @param loginLog
     * @param layuiPage
     * @return
     */
    @PostMapping("listLoginLog")
    @ResponseBody
    public LayuiTable listLoginLog(LoginLog loginLog, LayuiPage layuiPage) {
        return loginLogService.listLoginLog(loginLog, layuiPage);
    }
}
