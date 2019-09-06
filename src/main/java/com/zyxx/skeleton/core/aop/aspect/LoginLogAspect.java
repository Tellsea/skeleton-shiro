package com.zyxx.skeleton.core.aop.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zyxx.common.entity.LoginLog;
import com.zyxx.common.service.LoginLogService;
import com.zyxx.skeleton.core.global.dto.ResponseResult;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
import com.zyxx.skeleton.core.global.exception.GlobalException;
import com.zyxx.skeleton.core.util.AddressUtils;
import com.zyxx.skeleton.core.util.IpUtils;
import com.zyxx.skeleton.core.util.SpringContextUtils;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录日志切面
 *
 * @author Tellsea
 * @date 2019/7/18
 */
@Slf4j
@Aspect
@Component
@SuppressWarnings("all")
public class LoginLogAspect {

    @Autowired
    private LoginLogService loginLogService;

    /**
     * 登录日志切点
     */
    @Pointcut("@annotation(com.zyxx.skeleton.core.aop.annotation.LoginLog)")
    public void loginLogAspect() {
    }

    @Around("loginLogAspect()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws JsonProcessingException {
        Object result = null;
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        LoginLog loginLog = new LoginLog();
        loginLog.setCreateTime(new Date());
        Map<String, Object> fieldsName = getFieldsName(proceedingJoinPoint);
        fieldsName.entrySet().forEach(temp -> {
            if (StringUtils.equals("userName", temp.getKey())) {
                loginLog.setUserName(temp.getValue().toString());
            }
        });
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error("环绕切入异常");
            throw new GlobalException(StatusEnums.SERVER_ERROR);
        }
        String ip = IpUtils.getIpAddr(request);
        loginLog.setIp(ip);
        loginLog.setLocation(AddressUtils.getAddress(ip));
        ResponseResult rr = (ResponseResult) result;
        loginLog.setCode(rr.getCode());
        loginLog.setMessage(rr.getMessage());
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        loginLog.setDevice(browser.getName() + " -- " + operatingSystem.getName());
        loginLogService.insertSelective(loginLog);

        return result;
    }

    /**
     * 获取参数列表
     *
     * @param proceedingJoinPoint
     * @return
     */
    private static Map<String, Object> getFieldsName(ProceedingJoinPoint proceedingJoinPoint) {
        // 参数值
        Object[] args = proceedingJoinPoint.getArgs();
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        String[] parameterNames = pnd.getParameterNames(method);
        Map<String, Object> paramMap = new HashMap<>(32);
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], args[i]);
        }
        return paramMap;
    }
}
