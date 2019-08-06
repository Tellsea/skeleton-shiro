package cn.tellsea.skeleton.business.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import cn.tellsea.skeleton.business.entity.UserInfo;
import org.springframework.stereotype.Controller;
    import cn.tellsea.skeleton.core.base.controller.BaseController;

/**
* 用户表 前端控制器
*
* @author Tellsea
* @Description Created on 2019-08-06
*/
@Controller
@RequestMapping("userInfo")
public class UserInfoController extends BaseController<UserInfo> {

}
