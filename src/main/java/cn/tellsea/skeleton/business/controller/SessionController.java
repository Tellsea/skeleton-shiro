package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.business.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * session 管理 控制器
 *
 * @author Tellsea
 * @Description Created on 2019/7/17
 */
@Controller
@RequestMapping("/monitor")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/online")
    public String online(Model model) {
        model.addAttribute("onlineUserList", sessionService.getActiveSessions());
        return "page/monitor/online";
    }
}
