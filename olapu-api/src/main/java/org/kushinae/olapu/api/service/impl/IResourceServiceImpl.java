package org.kushinae.olapu.api.service.impl;

import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.interfaces.service.IResourceService;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.api.util.StringUtils;
import org.kushinae.olapu.repository.entities.Resource;
import org.kushinae.olapu.repository.enums.ResourceCategory;
import org.kushinae.olapu.repository.repository.impl.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class IResourceServiceImpl implements IResourceService {

    @jakarta.annotation.Resource
    ResourceRepository repository;

    @Override
    public ResourceRepository getRepository() {
        return repository;
    }

    @Override
    public List<Resource> getResources(Long parentId, String name, String uid, ResourceCategory category) {
        ResourceRepository repository = getRepository();
        return StringUtils.hasText(name) ?
                repository.findAllByParentIdAndNameLikeAndUidAndCategory(parentId, name, uid, category) :
                repository.findAllByParentIdAndUid(parentId, uid);
    }

    @Override
    public List<Resource> getResources(Long parentId, String uid) {
        return getRepository().findAllByParentIdAndUid(parentId, uid);
    }

    @Override
    public Resource getResourceById(Long id) {
        return getRepository().searchById(id);
    }

    @Override
    public void deleteResource(Long id, String uid) {
        Resource resource = getResourceById(id);
        AbstractAssert.notNull(resource, ErrorMessage.RESOURCE_DOES_NOT_EXIST);
        List<Resource> resources = getResources(id, uid);
        AbstractAssert.isEmpty(resources, ErrorMessage.RESOURCE_CHILDREN_EXISTS);
        getRepository().deleteById(id);
    }

    @Override
    public Long create(Resource payload) {
        if (payload.getParentId() != -1) {
            Resource resource = getRepository().searchById(payload.getParentId());
            AbstractAssert.notNull(resource, ErrorMessage.RESOURCE_DOES_NOT_EXIST);
        }

        Resource resource = getRepository().searchByParentIdAndNameAndType(payload.getParentId(), payload.getName(), payload.getType());
        AbstractAssert.isNull(resource, ErrorMessage.RESOURCE_DOES_NOT_EXIST);

        payload.setCreateAt(new Date());
        payload.setModifiedAt(new Date());
        payload.setDeleted(false);

        return getRepository().save(payload).getId();
    }
}
