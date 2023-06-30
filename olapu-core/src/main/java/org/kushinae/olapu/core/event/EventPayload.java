package org.kushinae.olapu.core.event;

import java.io.Serializable;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface EventPayload extends Serializable {

    String getId();

    String setId(String id);

}
