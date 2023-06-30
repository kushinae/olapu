package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.heimerdinger.core.utils.JacksonUtils;
import org.kushinae.olapu.core.event.EventPayload;
import org.kushinae.olapu.interfaces.service.IEventService;
import org.kushinae.olapu.repository.entities.EventDetail;
import org.kushinae.olapu.core.enums.EventMiddleware;
import org.kushinae.olapu.core.enums.EventTargetType;
import org.kushinae.olapu.core.enums.PubsubEvent;
import org.kushinae.olapu.core.enums.PubsubEventGroup;
import org.kushinae.olapu.repository.repository.impl.EventRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class EventServiceImpl implements IEventService {

    @Resource
    EventRepository eventRepository;

    @Override
    public EventRepository getRepository() {
        return eventRepository;
    }

    @Override
    public EventDetail register(String eventId, Serializable targetId, EventPayload eventPayload, EventTargetType targetType, PubsubEventGroup eventGroup, PubsubEvent event, EventMiddleware middleware) {
        EventDetail eventDetail = EventDetail.builder()
                .eventId(eventId)
                .targetId(targetId.toString())
                .targetType(targetType)
                .group(eventGroup)
                .type(event)
                .middleware(middleware)
                .content(JacksonUtils.toJsonString(eventPayload))
                .createAt(new Date())
                .modifiedAt(new Date())
                .deleted(false)
                .build();
        return getRepository().save(eventDetail);
    }

}
