package com.zyxx.common.controller;

import com.zyxx.common.entity.LoginLog;
import com.zyxx.common.service.LoginLogService;
import com.zyxx.skeleton.core.base.controller.BaseController;
import com.zyxx.skeleton.core.dto.ResponseResult;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
import com.zyxx.skeleton.assembly.layui.LayuiTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  前端控制器
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Controller
@RequestMapping("loginLog")
public class LoginLogController extends BaseController<LoginLogService> {

    @GetMapping("init")
    public String init() {
        return "admin/login_log";
    }

    /**
     * 新增
     *
     * @param loginLog
     * @return
     */
    @PostMapping("saveLoginLog")
    @ResponseBody
    public ResponseResult saveLoginLog(LoginLog loginLog) {
        baseService.insertSelective(loginLog);
        return ResponseResult.build(StatusEnums.SAVE_SUCCESS);
    }

    /**
     * 更新
     *
     * @param loginLog
     * @return
     */
    @PostMapping("updateLoginLog")
    @ResponseBody
    public ResponseResult updateLoginLog(LoginLog loginLog) {
        baseService.updateByPrimaryKeySelective(loginLog);
        return ResponseResult.build(StatusEnums.UPDATE_SUCCESS);
    }

    /**
     * 列表
     *
     * @param loginLog
     * @return
     */
    @PostMapping("listLoginLog")
    @ResponseBody
    public LayuiTable listLoginLog(LoginLog loginLog) {
        return baseService.listLoginLog(loginLog);
    }
}
