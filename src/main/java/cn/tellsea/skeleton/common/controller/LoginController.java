package cn.tellsea.skeleton.common.controller;

import cn.tellsea.skeleton.core.aop.annotation.LoginLog;
import cn.tellsea.skeleton.core.consts.SystemConst;
import cn.tellsea.skeleton.core.global.dto.ResponseResult;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import cn.tellsea.skeleton.core.util.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
 * @Description Created on 2019/7/13
 */
@Slf4j
@Controller
public class LoginController {

    /**
     * 跳转登录页
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @param rememberMe
     * @param captcha
     * @param request
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    @LoginLog
    public ResponseResult login(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam(value = "rememberMe", required = false) boolean rememberMe,
                                @RequestParam("captcha") String captcha,
                                HttpServletRequest request) {
        // 校验验证码
        String sessionCaptcha = (String) ShiroUtils.getSessionAttribute(SystemConst.KEY_CAPTCHA);
        if (null == captcha || !captcha.equalsIgnoreCase(sessionCaptcha)) {
            return ResponseResult.build(StatusEnums.CAPTCHA_ERROR);
        }

        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
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
            return ResponseResult.build(StatusEnums.UNAUTHORIZED, username);
        } catch (UnknownAccountException e) {
            return ResponseResult.build(StatusEnums.USER_NOT_FOUND, username);
        } catch (IncorrectCredentialsException e) {
            return ResponseResult.build(StatusEnums.PASSWORD_ERROR, username);
        }
    }
}
