package org.kushinae.olapu.core.event;


import org.kushinae.heimerdinger.core.entities.Job;
import org.kushinae.olapu.core.enums.PubsubEventGroup;
import org.kushinae.olapu.core.event.Event;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractJobEventGroup<M> implements Event<M> {

    @Resource
    protected ComponentFactory componentFactory;

    @Resource
    protected JobRepository jobRepository;

    protected Job getJob(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.JOB_DOES_NOT_EXIST.getCode()));
    }

    @Override
    public PubsubEventGroup eventGroup() {
        return PubsubEventGroup.JOB;
    }
}
