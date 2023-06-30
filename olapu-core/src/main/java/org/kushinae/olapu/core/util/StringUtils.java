package org.kushinae.olapu.core.util;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class StringUtils extends org.springframework.util.StringUtils {

    public static boolean nonText(String text) {
        return !StringUtils.hasText(text);
    }

}
