package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.heimerdinger.core.entities.generate.GenerateJob;
import org.kushinae.heimerdinger.core.generate.Record;
import org.kushinae.heimerdinger.core.utils.JacksonUtils;
import org.kushinae.heimerdinger.spi.factory.generate.DefaultGenerateChain;
import org.kushinae.olapu.api.components.ComponentFactory;
import org.kushinae.olapu.interfaces.service.IEventService;
import org.kushinae.olapu.repository.entities.EventDetail;
import org.kushinae.olapu.core.enums.EventMiddleware;
import org.kushinae.olapu.core.enums.EventTargetType;
import org.kushinae.olapu.core.enums.PubsubEvent;
import org.kushinae.olapu.core.enums.PubsubEventGroup;
import org.kushinae.olapu.core.event.Event;
import org.kushinae.olapu.api.event.factory.EventFactory;
import org.kushinae.olapu.core.event.payload.BuildJobPayload;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.interfaces.service.IJobService;
import org.kushinae.olapu.repository.entities.Job;
import org.kushinae.olapu.repository.repository.impl.JobRepository;
import org.springframework.stereotype.Service;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class JobServiceImpl implements IJobService {

    @Resource
    JobRepository repository;

    @Resource
    EventFactory eventFactory;

    @Resource
    ComponentFactory componentFactory;

    @Resource
    IEventService eventService;

    @Override
    public JobRepository getRepository() {
        return repository;
    }

    @Override
    public Long createJob(Job job) {
        job.setBuilt(false);
        return componentFactory.getJobComponent(job.getModel()).save(job).getId();
    }

    @Override
    public Record start(Long id) {
        Job job = queryById(id);
        if (!job.getBuilt()) {
            throw new IllegalCallerException(ErrorMessage.JOB_UNREADY.getCode());
        }
        DefaultGenerateChain chain = new DefaultGenerateChain();
        return chain.chain(JacksonUtils.toJavaBean(job.getScript(), GenerateJob.class));
    }

    @Override
    public Job queryById(Long id) {
        return getRepository().findById(id).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.JOB_DOES_NOT_EXIST.getCode()));
    }

    @Override
    public void build(Long id) {
        EventDetail eventDetail = eventService.register(null, id, BuildJobPayload.builder().jobId(id).build(), EventTargetType.JOB, PubsubEventGroup.JOB, PubsubEvent.BUILD, EventMiddleware.DISRUPTOR);
        Event<BuildJobPayload> event = eventFactory.getInstance(PubsubEventGroup.JOB, PubsubEvent.BUILD, BuildJobPayload.class);
        event.publisher(null, BuildJobPayload.builder().jobId(id).build());
    }

    @Override
    public Job save(Job job) {
        return getRepository().save(job);
    }

    @Override
    public Job updateJob(Job job) {
        job.setBuilt(false);
        return componentFactory.getJobComponent(job.getModel()).save(job);
    }
}
