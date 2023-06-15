package org.kushinae.olapu.api.util;

import java.util.Collection;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class CollectionUtils extends org.springframework.util.CollectionUtils {

    public static boolean notEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

}
