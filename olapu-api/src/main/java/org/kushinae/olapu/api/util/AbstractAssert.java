package org.kushinae.olapu.api.util;

import org.kushinae.olapu.api.http.ErrorMessage;
import org.springframework.util.Assert;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractAssert extends org.springframework.util.Assert {

    /**
     * 断言对象必须不为 {@code null}
     *  <pre class="code">AbstractAssert.notNull(value, "该值必须不为空");</pre>
     * @param o 要检查的对象
     * @param message 断言失败时使用的异常消息 如果为异常消息则会通过 {@link ErrorMessage#getCode()} 进行国际化
     * @throws IllegalArgumentException – 如果对象为空
     */
    public static void notNull(Object o, ErrorMessage message) {
        Assert.notNull(o, message.getCode());
    }

    /**
     * 断言对象必须为 {@code null}
     *  <pre class="code">AbstractAssert.isNull(value, "该值必须为空");</pre>
     * @param o 要检查的对象
     * @param message 断言失败时使用的异常消息 如果为异常消息则会通过 {@link ErrorMessage#getCode()} 进行国际化
     * @throws IllegalArgumentException – 如果对象不为空
     */
    public static void isNull(Object o, ErrorMessage message) {
        Assert.isNull(o, message.getCode());
    }

    /**
     * 断言字符串必须不为 {@code null} 以及 {@code ""}
     *
     * @param text 需要被断言的字符串
     * @param message 断言失败之后抛出异常消息
     * @throws IllegalArgumentException 当 text 为空时抛出异常
     */
    public static void hasText(String text, ErrorMessage message) {
        Assert.hasText(text, message.getCode());
    }

    public static void isEquals(Object obj, Object target) {
        if (!ObjectUtils.nullSafeEquals(obj, target)) {

        }
    }
}
