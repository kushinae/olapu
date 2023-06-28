package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.interfaces.service.IEventService;
import org.kushinae.olapu.repository.repository.impl.EventRepository;
import org.springframework.stereotype.Service;

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
}
