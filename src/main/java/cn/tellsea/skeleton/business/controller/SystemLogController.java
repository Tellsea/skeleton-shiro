package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.business.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * 系统日志表 前端控制器
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Controller
@RequestMapping("systemLog")
public class SystemLogController {

    @Autowired
    private SystemLogService systemLogService;

}
