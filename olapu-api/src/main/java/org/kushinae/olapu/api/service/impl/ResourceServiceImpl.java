package org.kushinae.olapu.api.service.impl;

import org.kushinae.olapu.api.authorization.Authorization;
import org.kushinae.olapu.api.convert.ResourceConvert;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.api.service.ResourceService;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.api.util.StringUtils;
import org.kushinae.olapu.api.vo.resource.EditResource;
import org.kushinae.olapu.repository.entities.Resource;
import org.kushinae.olapu.repository.repository.impl.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @jakarta.annotation.Resource
    ResourceRepository repository;

    @jakarta.annotation.Resource
    Authorization authorization;



    @Override
    public ResourceRepository getRepository() {
        return repository;
    }

    @Override
    public List<Resource> getResources(Long parentId, String name, String uid) {
        ResourceRepository repository = getRepository();
        return StringUtils.hasText(name) ?
                repository.findAllByParentIdAndNameAndUid(parentId, name, uid) :
                repository.findAllByParentIdAndUid(parentId, uid);
    }

    @Override
    public Long create(EditResource payload) {

        if (payload.getParentId() != -1) {
            Resource resource = getRepository().searchById(payload.getParentId());
            AbstractAssert.notNull(resource, ErrorMessage.RESOURCE_DOES_NOT_EXIST);
        }

        Resource resource = getRepository().searchByParentIdAndNameAndType(payload.getParentId(), payload.getName(), payload.getType());
        AbstractAssert.isNull(resource, ErrorMessage.RESOURCE_DOES_NOT_EXIST);

        resource = ResourceConvert.INSTANCE.toEntity(payload);
        resource.setCreateAt(new Date());
        resource.setModifiedAt(new Date());
        resource.setDeleted(false);
        resource.setUid(authorization.getUid());

        return getRepository().save(resource).getId();
    }
}
