package com.zyxx.skeleton.core.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
    /**
     * 权限更新切点
     */
    @Pointcut("@annotation(com.zyxx.skeleton.core.aop.annotation.DynamicShiro)")
    public void dynamicShiroAspect() {
    }

    @After("dynamicShiroAspect()")
    public void after() {
        System.out.println("切面操作");
    }
}