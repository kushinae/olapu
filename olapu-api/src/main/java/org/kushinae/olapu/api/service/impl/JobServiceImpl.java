package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.components.ComponentFactory;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.api.service.JobService;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.core.job.entities.generate.GenerateJob;
import org.kushinae.olapu.core.utils.JacksonUtils;
import org.kushinae.olapu.generate.Record;
import org.kushinae.olapu.repository.entities.Job;
import org.kushinae.olapu.repository.repository.impl.JobRepository;
import org.kushinae.olapu.spi.factory.DefaultGenerateChain;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class JobServiceImpl implements JobService {

    @Resource
    JobRepository repository;

    @Resource
    ComponentFactory componentFactory;

    @Override
    public JobRepository getRepository() {
        return repository;
    }

    @Override
    public Long createJob(Job job) {
        return componentFactory.getJobComponent(job.getModel()).save(job).getId();
    }

    @Override
    public Record start(Long id) {
        Job job = queryById(id);
        DefaultGenerateChain chain = new DefaultGenerateChain();
        return chain.chain(JacksonUtils.toJavaBean(job.getScript(), GenerateJob.class));
    }

    @Override
    public Job queryById(Long id) {
        return getRepository().findById(id).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.JOB_NAME_ALREADY_EXISTS.getCode()));
    }
}
