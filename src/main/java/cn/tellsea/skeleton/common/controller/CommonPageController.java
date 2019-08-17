package cn.tellsea.skeleton.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面跳转控制器
 *
 * @author Tellsea
 * @Description Created on 2019/8/10
 */
@Controller
public class CommonPageController {

    @GetMapping("/")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/console")
    public String console() {
        return "admin/console";
    }
}
