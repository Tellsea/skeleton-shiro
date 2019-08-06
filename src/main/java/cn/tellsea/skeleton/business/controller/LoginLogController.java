package cn.tellsea.skeleton.business.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import cn.tellsea.skeleton.business.entity.LoginLog;
import org.springframework.stereotype.Controller;
    import cn.tellsea.skeleton.core.base.controller.BaseController;

/**
*  前端控制器
*
* @author Tellsea
* @Description Created on 2019-08-06
*/
@Controller
@RequestMapping("loginLog")
public class LoginLogController extends BaseController<LoginLog> {

}
