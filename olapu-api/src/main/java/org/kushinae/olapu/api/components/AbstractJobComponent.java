package org.kushinae.olapu.api.components;

import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.kushinae.olapu.repository.entities.Job;
import org.kushinae.olapu.repository.repository.impl.JobRepository;

import java.util.Date;
import java.util.Objects;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Log4j2
public abstract class AbstractJobComponent implements JobComponent {

    @Resource
    JobRepository jobRepository;

    @Override
    public boolean supportedSave(Job job) {
        Job byResourceIdAndName = jobRepository.findByResourceIdAndName(job.getResourceId(), job.getName());
        return Objects.isNull(byResourceIdAndName) || job.getId() != null;
    }

    @Override
    public Job onSaveBefore(Job job) {
        if (Objects.isNull(job.getId())) {
            job.setCreateAt(new Date());
        }
        job.setDeleted(false);
        job.setModifiedAt(new Date());
        return job;
    }

    @Override
    public String buildScript(Job job) {
        job.setBuilt(true);
        return job.getScript();
    }

    @Override
    public Job save(Job job) {
        if (supportedSave(job)) {
            // supported code ...
            job = onSaveBefore(job);
            return jobRepository.save(job);
        } else {
            // unsupported code ...
            if (log.isErrorEnabled()) {
                log.error("[Job component] The current operation {} is not supported whit save job", job.getModel().getCode());
            }
            throw new IllegalArgumentException("The current operation " + job.getModel().getCode() + " is not supported whit save job");
        }
    }

}
