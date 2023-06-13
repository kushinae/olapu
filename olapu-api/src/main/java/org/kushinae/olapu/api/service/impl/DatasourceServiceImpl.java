package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.api.service.DatasourceService;
import org.kushinae.olapu.api.service.ResourceService;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.repository.entities.Datasource;
import org.kushinae.olapu.repository.repository.impl.DatasourceRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

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
    public Repository<Datasource, Long> getRepository() {
        return datasourceRepository;
    }

    @Override
    public Long create(Datasource entity) {

        org.kushinae.olapu.repository.entities.Resource resource = resourceService.getResourceById(entity.getResourceId());
        AbstractAssert.isNull(resource, ErrorMessage.RESOURCE_DOES_NOT_EXIST);


        return null;
    }
}
