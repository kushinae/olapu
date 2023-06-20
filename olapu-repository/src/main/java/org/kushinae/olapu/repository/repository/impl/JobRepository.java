package org.kushinae.olapu.repository.repository.impl;

import org.kushinae.olapu.repository.entities.Job;
import org.kushinae.olapu.repository.repository.IServiceRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Repository
public interface JobRepository extends IServiceRepository<Job, Long> {

    Job findByResourceIdAndName(Long resourceId, String name);

}
