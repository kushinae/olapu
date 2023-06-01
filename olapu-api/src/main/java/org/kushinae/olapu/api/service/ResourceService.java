package org.kushinae.olapu.api.service;

import org.kushinae.olapu.api.vo.resource.EditResource;
import org.kushinae.olapu.repository.entities.Resource;
import org.kushinae.olapu.repository.repository.IRepositoryService;
import org.kushinae.olapu.repository.repository.ResourceRepository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface ResourceService extends IRepositoryService<Resource, Long> {
    Long create(EditResource payload);

    @Override
    ResourceRepository getRepository();
}
