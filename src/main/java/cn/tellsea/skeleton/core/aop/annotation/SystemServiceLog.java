package cn.tellsea.skeleton.core.aop.annotation;

import java.lang.annotation.*;

/**
 * 系统service层自定义注解
 *
 * @author Tellsea
 * @date 2019/7/17
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {

    String value() default "";
}
