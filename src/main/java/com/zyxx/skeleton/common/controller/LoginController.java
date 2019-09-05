package com.zyxx.skeleton.common.controller;

import com.zyxx.skeleton.core.aop.annotation.LoginLog;
import com.zyxx.skeleton.core.consts.SessionConst;
import com.zyxx.skeleton.core.global.dto.ResponseResult;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
import com.zyxx.skeleton.core.util.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制器
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@Slf4j
@Controller
public class LoginController {

    /**
     * 跳转登录页
     *
     * @return
     */
    @GetMapping("login")
    public String login() {
        return "admin/login";
    }

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @param rememberMe
     * @param captcha
     * @param request
     * @return
     */
    @PostMapping("login")
    @ResponseBody
    @LoginLog
    public ResponseResult login(@RequestParam("userName") String userName,
                                @RequestParam("password") String password,
                                @RequestParam(value = "rememberMe", required = false) boolean rememberMe,
                                @RequestParam("captcha") String captcha,
                                HttpServletRequest request) {
        // 校验验证码
        String sessionCaptcha = (String) ShiroUtils.getSessionAttribute(SessionConst.KEY_CAPTCHA);
        if (null == captcha || !captcha.equalsIgnoreCase(sessionCaptcha)) {
            return ResponseResult.build(StatusEnums.CAPTCHA_ERROR);
        }

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            // 返回之前请求路径
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String loginSuccessUrl = "/";
            if (null != savedRequest) {
                loginSuccessUrl = savedRequest.getRequestUrl();
            }
            return ResponseResult.build(StatusEnums.OK, loginSuccessUrl);

        } catch (DisabledAccountException e) {
            return ResponseResult.build(StatusEnums.LOCKED_ACCOUNT_ERROR, userName);
        } catch (UnknownAccountException e) {
            return ResponseResult.build(StatusEnums.USER_NOT_FOUND, userName);
        } catch (IncorrectCredentialsException e) {
            return ResponseResult.build(StatusEnums.PASSWORD_ERROR, userName);
        }
    }
}
