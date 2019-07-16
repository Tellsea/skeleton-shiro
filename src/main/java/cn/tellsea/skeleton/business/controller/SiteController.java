package cn.tellsea.skeleton.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面跳转主控制器
 *
 * @author Tellsea
 * @Description Created on 2019/7/13
 */
@Controller
public class SiteController {

    /**
     * 首页
     *
     * @return
     */
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "page/index";
    }

    /**
     * 数据面板
     *
     * @return
     */
    @GetMapping("/console/data")
    public String consoleData() {
        return "page/console/data";
    }

    /**
     * 权限面板
     *
     * @return
     */
    @GetMapping("/console/permission")
    public String consolePermission() {
        return "page/console/permission";
    }
}
