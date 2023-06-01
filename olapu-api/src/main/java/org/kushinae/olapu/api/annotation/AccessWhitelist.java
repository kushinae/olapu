package org.kushinae.olapu.api.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 鉴权访问白名单注解, 使用此注解可以标记API作为免鉴权接口
 *  标记在方法: 则说明此接口无需身份权限验证
 *  标记在类: 则说明此类下所有接口无需身份权限验证
 *
 * @author kaisa.liu
 * @since 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AccessWhitelist {

}
