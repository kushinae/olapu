package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.api.service.DatasourceService;
import org.kushinae.olapu.api.service.ResourceService;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.repository.entities.Datasource;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.kushinae.olapu.repository.enums.FileType;
import org.kushinae.olapu.repository.repository.impl.DatasourceRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class DatasourceServiceImpl implements DatasourceService {

    @Resource
    DatasourceRepository datasourceRepository;

    @Resource
    ResourceService resourceService;

    @Override
    public DatasourceRepository getRepository() {
        return datasourceRepository;
    }

    @Override
    public Long create(Datasource entity) {

        org.kushinae.olapu.repository.entities.Resource resource = resourceService.getResourceById(entity.getResourceId());
        AbstractAssert.notNull(resource, ErrorMessage.RESOURCE_DOES_NOT_EXIST);
        AbstractAssert.notEquals(resource.getType(), FileType.FILE, ErrorMessage.UNSUPPORTED_RESOURCE_TYPE);

        Datasource datasource = getRepository().searchByNameAndUidAndTypeAndResourceId(entity.getName(), entity.getUid(), entity.getType(), entity.getResourceId());
        AbstractAssert.isNull(datasource, ErrorMessage.DATASOURCE_ALREADY_EXISTS);
        entity.setCreateAt(new Date());
        entity.setModifiedAt(new Date());
        entity.setDeleted(false);

        return getRepository().save(entity).getId();
    }

    @Override
    public Datasource queryTemplate(DatasourceType type) {
        return getRepository().searchByTypeAndTemplateIsTrue(type);
    }

    @Override
    public Datasource queryById(Long id, String uid) {
        return getRepository().searchByIdAndUid(id, uid);
    }

}
