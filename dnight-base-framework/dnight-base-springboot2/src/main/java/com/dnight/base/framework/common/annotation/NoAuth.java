package com.dnight.base.framework.common.annotation;

import java.lang.annotation.*;

/**
 *  标示请求无需通过无权限校验
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoAuth {
}
