package org.kushinae.olapu.core.event.support;

import lombok.extern.log4j.Log4j2;
import org.kushinae.heimerdinger.core.entities.Job;
import org.kushinae.olapu.core.enums.PubsubEvent;
import org.kushinae.olapu.core.event.payload.BuildJobPayload;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Log4j2
public class BuildJobEvent extends AbstractDisruptorEvent<BuildJobPayload> {

    @Override
    public void subscription(BuildJobPayload message) {
        Job job = getJob(message.getJobId());
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
