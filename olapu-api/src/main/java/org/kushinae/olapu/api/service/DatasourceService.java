package org.kushinae.olapu.api.service;

import org.kushinae.olapu.repository.entities.Datasource;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface DatasourceService extends IRepositoryService<Datasource, Long> {
    Long create(Datasource entity);
}
