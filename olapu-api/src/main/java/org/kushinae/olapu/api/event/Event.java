package org.kushinae.olapu.api.event;

import org.kushinae.olapu.repository.enums.PubsubEvent;
import org.kushinae.olapu.repository.enums.PubsubEventGroup;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface Event<M> {

    void publisher(String topic, M message);

    void subscription(M message);

    PubsubEvent event();

    PubsubEventGroup eventGroup();

}
