package com.cn.annotation;

import java.lang.annotation.*;

/**
 * @Author: ReZero
 * @Date: 5/11/19 6:30 PM
 * @Version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {

    String module() default "";
    String operation() default "";


}
