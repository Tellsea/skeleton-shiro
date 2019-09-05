package com.zyxx.skeleton.core.aop.annotation;

import java.lang.annotation.*;

/**
 * 动态更新 shiro 自定义注解
 *
 * @author: Tellsea
 * @date: 2019/09/05
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicShiro {

}