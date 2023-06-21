package org.kushinae.olapu.api.event.factory;

import com.lmax.disruptor.EventFactory;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class DisruptorEventFactory<T> implements EventFactory<T> {

    private final T eventPayload;

    public DisruptorEventFactory(T eventPayload) {
        this.eventPayload = eventPayload;
    }

    @Override
    public T newInstance() {
        return eventPayload;
    }
}
