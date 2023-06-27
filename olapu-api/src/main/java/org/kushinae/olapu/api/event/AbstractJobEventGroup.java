package org.kushinae.olapu.api.event;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.components.ComponentFactory;
import org.kushinae.olapu.interfaces.enums.PubsubEventGroup;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.repository.entities.Job;
import org.kushinae.olapu.repository.repository.impl.JobRepository;

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
