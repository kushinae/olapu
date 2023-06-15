package org.kushinae.olapu.api.service;

import org.kushinae.olapu.repository.entities.Datasource;
import org.kushinae.olapu.repository.enums.DatasourceType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface DatasourceService extends IRepositoryService<Datasource, Long> {
    Long create(Datasource entity);

    Datasource queryTemplate(DatasourceType type);

    Datasource queryById(Long id, String uid);
}
