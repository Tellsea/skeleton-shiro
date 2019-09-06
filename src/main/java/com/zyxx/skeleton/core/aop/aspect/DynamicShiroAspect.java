package com.zyxx.skeleton.core.aop.aspect;

import com.zyxx.common.service.ShiroService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 动态更新shiro切面
 *
 * @author Tellsea
 * @date 2019/09/05
 */
@Slf4j
@Aspect
@Component
@SuppressWarnings("all")
public class DynamicShiroAspect {

    @Autowired
    private ShiroService shiroService;

    /**
     * 权限更新切点
     */
    @Pointcut("@annotation(com.zyxx.skeleton.core.aop.annotation.DynamicShiro)")
    public void dynamicShiroAspect() {
    }

    @After("dynamicShiroAspect()")
    public void after() {
        shiroService.updatePermission();
        log.info("DynamicShiroAspect: shiro 动态更新权限成功...");
    }
}