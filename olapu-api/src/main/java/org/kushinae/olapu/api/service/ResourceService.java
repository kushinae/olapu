package org.kushinae.olapu.api.service;

import org.kushinae.olapu.repository.entities.Resource;
import org.kushinae.olapu.repository.enums.ResourceCategory;
import org.kushinae.olapu.repository.repository.impl.ResourceRepository;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface ResourceService extends IRepositoryService<Resource, Long> {
    Long create(Resource resource);

    @Override
    ResourceRepository getRepository();

    List<Resource> getResources(Long parentId, String name, String uid, ResourceCategory category);

    List<Resource> getResources(Long parentId, String uid);

    Resource getResourceById(Long id);

    void deleteResource(Long id, String uid);
}
