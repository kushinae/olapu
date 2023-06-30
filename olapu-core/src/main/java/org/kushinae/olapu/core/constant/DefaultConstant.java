package org.kushinae.olapu.core.constant;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class DefaultConstant {

    /**
     * 如果创建的事件对象为空的话则使用该值维护
     */
    public static volatile AtomicLong IF_EMPTY_DEFAULT_EVENT_ID = new AtomicLong(0);

}
