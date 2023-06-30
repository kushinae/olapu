package org.kushinae.olapu.interfaces.service;

import org.kushinae.olapu.repository.entities.Resource;
import org.kushinae.olapu.core.enums.ResourceCategory;
import org.kushinae.olapu.repository.repository.impl.ResourceRepository;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IResourceService extends IRepositoryService<Resource, Long, ResourceRepository> {
    Long create(Resource resource);

    @Override
    ResourceRepository getRepository();

    List<Resource> getResources(Long parentId, String name, String uid, ResourceCategory category);

    List<Resource> getResources(Long parentId, String uid);

    Resource getResourceById(Long id);

    void deleteResource(Long id, String uid);
}
