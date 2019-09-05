package com.zyxx.skeleton.core.global.handle;

import com.zyxx.skeleton.core.global.dto.ResponseResult;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
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
    public ResponseResult exception(Exception e) {
        log.error("【错误原因】{}", e.getClass());
        log.error("【错误描述】{}", e.getMessage());
        e.printStackTrace();
        return ResponseResult.build(StatusEnums.SERVER_ERROR);
    }

    @ExceptionHandler(value = GlobalException.class)
    public String globalExceptionHandle(GlobalException e, Model model) {
        model.addAttribute("test", "123456");
        log.error("【错误原因】{}", e.getClass());
        log.error("【错误描述】{}", e.getMessage());
        e.printStackTrace();
        return "admin/404";
    }
}
