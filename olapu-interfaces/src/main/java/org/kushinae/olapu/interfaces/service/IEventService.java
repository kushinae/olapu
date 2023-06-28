package org.kushinae.olapu.interfaces.service;

import org.kushinae.olapu.repository.entities.EventDetail;
import org.kushinae.olapu.repository.repository.impl.EventRepository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IEventService extends IRepositoryService<EventDetail, Long, EventRepository> {

}
