package org.kushinae.olapu.api.service;

import org.kushinae.olapu.generate.Record;
import org.kushinae.olapu.repository.entities.Job;
import org.kushinae.olapu.repository.repository.impl.JobRepository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface JobService extends IRepositoryService<Job, Long> {

    JobRepository getRepository();

    Long createJob(Job edit2Entity);

    Record start(Long id);

    Job queryById(Long id);

    void build(Long id);

    Job save(Job job);
}
