package cn.tellsea.skeleton.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 跳转 控制器
 * @author Tellsea
 * @Description Created on 2019/8/4
 */
@Controller
public class PageController {

    @GetMapping("")
    public String index() {
        return "admin/index";
    }
}
