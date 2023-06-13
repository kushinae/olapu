package org.kushinae.olapu.repository.repository.impl;

import org.kushinae.olapu.repository.entities.Datasource;
import org.kushinae.olapu.repository.repository.IServiceRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Repository
public interface DatasourceRepository extends IServiceRepository<Datasource, Long> {
}
