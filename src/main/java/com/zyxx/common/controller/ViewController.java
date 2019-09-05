package com.zyxx.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 页面跳转控制器
 *
 * @author Tellsea
 * @date 2019/8/10
 */
@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/console/{name}")
    public String console(@PathVariable String name) {
        return "admin/" + name;
    }

    @GetMapping("403")
    public String unauthorized() {
        return "admin/403";
    }
}
