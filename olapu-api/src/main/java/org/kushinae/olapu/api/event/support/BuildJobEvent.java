package org.kushinae.olapu.api.event.support;

import lombok.extern.log4j.Log4j2;
import org.kushinae.olapu.api.components.JobComponent;
import org.kushinae.olapu.api.enums.PubsubEvent;
import org.kushinae.olapu.api.event.AbstractDisruptorEvent;
import org.kushinae.olapu.api.event.payload.BuildJobPayload;
import org.kushinae.olapu.repository.entities.Job;
import org.springframework.stereotype.Component;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Log4j2
@Component
public class BuildJobEvent extends AbstractDisruptorEvent<BuildJobPayload> {

    @Override
    public void subscription(BuildJobPayload message) {
        Job job = getJob(message.getId());
        JobComponent jobComponent = componentFactory.getJobComponent(job.getModel());
        String script = jobComponent.buildScript(job);
        job.setScript(script);
        jobComponent.save(job);
    }

    @Override
    public PubsubEvent event() {
        return PubsubEvent.BUILD;
    }

}
