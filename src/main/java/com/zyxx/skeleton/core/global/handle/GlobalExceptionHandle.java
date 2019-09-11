package com.zyxx.skeleton.core.global.handle;

import com.zyxx.skeleton.core.global.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@Slf4j
@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public String exception(Exception e, Model model) {
        model.addAttribute("code", e.getClass());
        model.addAttribute("info", e.getMessage());
        log.error("【错误原因】{}", e.getClass());
        log.error("【错误描述】{}", e.getMessage());
        e.printStackTrace();
        return "admin/error";
    }

    @ExceptionHandler(value = GlobalException.class)
    public String globalExceptionHandle(GlobalException e, Model model) {
        model.addAttribute("code", e.getBaseEnums().getCode());
        model.addAttribute("info", e.getBaseEnums().getInfo());
        log.error("【错误原因】{}", e.getClass());
        log.error("【错误描述】{}", e.getMessage());
        e.printStackTrace();
        return "admin/error";
    }
}
