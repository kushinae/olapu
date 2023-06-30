package org.kushinae.olapu.core.event.payload;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.kushinae.olapu.core.event.AbstractEventPayload;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class BuildJobPayload extends AbstractEventPayload {

    private Long jobId;

}
