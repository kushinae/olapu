package org.kushinae.olapu.interfaces.service;

import org.kushinae.olapu.core.event.EventPayload;
import org.kushinae.olapu.repository.entities.EventDetail;
import org.kushinae.olapu.core.enums.EventMiddleware;
import org.kushinae.olapu.core.enums.EventTargetType;
import org.kushinae.olapu.core.enums.PubsubEvent;
import org.kushinae.olapu.core.enums.PubsubEventGroup;
import org.kushinae.olapu.repository.repository.impl.EventRepository;

import java.io.Serializable;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IEventService extends IRepositoryService<EventDetail, Long, EventRepository> {

    /**
     * 注册事件
     *
     * @param eventId    事件ID 可以为空
     * @param targetId
     * @param targetId   事件对象事件内容
     * @param targetType 事件对象类型
     * @param eventGroup 事件类型组
     * @param event      事件类型
     * @param middleware 事件使用中间件
     * @return 创建的事件对象
     */
    EventDetail register(String eventId, Serializable targetId, EventPayload eventPayload, EventTargetType targetType, PubsubEventGroup eventGroup, PubsubEvent event, EventMiddleware middleware);
}
