package org.kushinae.olapu.core.utils;

import java.util.Collection;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

}
