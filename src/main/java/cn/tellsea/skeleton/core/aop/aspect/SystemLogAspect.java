package cn.tellsea.skeleton.core.aop.aspect;

import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.core.aop.annotation.SystemControllerLog;
import cn.tellsea.skeleton.core.aop.annotation.SystemServiceLog;
import cn.tellsea.skeleton.core.util.IpUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 系统日志切面
 *
 * @author Tellsea
 * @Description Created on 2019/7/18
 */
@Slf4j
@Aspect
@Component
@SuppressWarnings("all")
public class SystemLogAspect {

    /**
     * Controller层切点
     */
    @Pointcut("@annotation(cn.tellsea.skeleton.core.aop.annotation.SystemControllerLog)")
    public void controllerAspect() {
    }

    /**
     * Service层切点
     */
    @Pointcut("@annotation(cn.tellsea.skeleton.core.aop.annotation.SystemServiceLog)")
    public void serviceAspect() {
    }

    /**
     * 前置通知  用于拦截Controller层记录用户的操作
     *
     * @param joinPoint
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String ip = IpUtils.getIpAddr(request);
        try {
            log.info("-------------------------------------------------------");
            log.info("请求接口" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()));
            log.info("方法描述：" + getControllerMethodDescription(joinPoint));
            log.info("请求人：" + user.getUsername());
            log.info("请求ip：" + ip);

            // todo 保存日志到数据库
        } catch (Exception e) {
            log.error("==前置通知异常==");
            log.error("异常信息：{}", e.getMessage());
        }
    }

    /**
     * 异常通知 用于拦截service层记录异常日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String ip = IpUtils.getIpAddr(request);
        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                params += JSONObject.toJSON(joinPoint.getArgs()[i]) + ";";
            }
        }
        try {
            log.info("-------------------------------------------------------");
            log.info("异常代码:" + e.getClass().getName());
            log.info("异常信息:" + e.getMessage());
            log.info("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            log.info("方法描述:" + getServiceMethodDescription(joinPoint));
            log.info("请求人:" + user.getUsername());
            log.info("请求IP:" + ip);
            log.info("请求参数:" + params);

            // todo 保存日志到数据库
        } catch (Exception ex) {
            log.error("异常信息:{}", ex.getMessage());
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public static String getServiceMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemServiceLog.class).value();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemControllerLog.class).value();
                    break;
                }
            }
        }
        return description;
    }
}
