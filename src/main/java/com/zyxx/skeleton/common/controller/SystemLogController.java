package com.zyxx.skeleton.common.controller;

import com.zyxx.skeleton.common.entity.SystemLog;
import com.zyxx.skeleton.common.service.SystemLogService;
import com.zyxx.skeleton.core.base.controller.BaseController;
import com.zyxx.skeleton.core.global.dto.ResponseResult;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统日志表 前端控制器
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Controller
@RequestMapping("systemLog")
public class SystemLogController extends BaseController<SystemLogService> {

    @GetMapping("init")
    public String init() {
        return "admin/system_log";
    }

    /**
     * 新增
     *
     * @param systemLog
     * @return
     */
    @PostMapping("saveSystemLog")
    @ResponseBody
    public ResponseResult saveSystemLog(SystemLog systemLog) {
        baseService.insertSelective(systemLog);
        return ResponseResult.build(StatusEnums.SAVE_SUCCESS);
    }

    /**
     * 更新
     *
     * @param systemLog
     * @return
     */
    @PostMapping("updateSystemLog")
    @ResponseBody
    public ResponseResult updateSystemLog(SystemLog systemLog) {
        baseService.updateByPrimaryKeySelective(systemLog);
        return ResponseResult.build(StatusEnums.UPDATE_SUCCESS);
    }
}
