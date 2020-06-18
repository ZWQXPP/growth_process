package com.leyou.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 支持模糊查询
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE, ElementType.METHOD,ElementType.FIELD})
public @interface Wildcard {
}
