package cn.tellsea.skeleton.core.aop.annotation;

import java.lang.annotation.*;

/**
 * 系统日志自定义注解
 *
 * @author Tellsea
 * @Description Created on 2019/7/17
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {

    String value() default "";
}
