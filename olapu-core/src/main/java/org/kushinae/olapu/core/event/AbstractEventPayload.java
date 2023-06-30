package org.kushinae.olapu.core.event;


import org.kushinae.olapu.core.constant.DefaultConstant;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractEventPayload implements EventPayload {

    protected String id = String.valueOf(DefaultConstant.IF_EMPTY_DEFAULT_EVENT_ID.getAndIncrement());

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String setId(String id) {
        return this.id = id;
    }
}
