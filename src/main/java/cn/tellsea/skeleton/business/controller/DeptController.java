package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.business.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * 部门表 前端控制器
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Controller
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

}
