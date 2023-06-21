package org.kushinae.olapu.api.event.factory;

import jakarta.annotation.Resource;
import org.checkerframework.checker.units.qual.C;
import org.kushinae.olapu.api.enums.PubsubEvent;
import org.kushinae.olapu.api.enums.PubsubEventGroup;
import org.kushinae.olapu.api.event.Event;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Component
public class EventFactory {

    @Resource
    List<Event<?>> events;

    public <M> Event<M> getInstance(PubsubEventGroup eventGroup, PubsubEvent event, Class<M> messageType) {
        for (Event<?> eventHandler : events) {
            if (eventHandler.eventGroup().equals(eventGroup) && eventHandler.event().equals(event)) {
                return (Event<M>) eventHandler;
            }
        }
        throw new IllegalArgumentException("Unsupported event with group " + eventGroup.getCode() + " and event " + event.getCode());
    }

}
