package org.kushinae.olapu.repository.repository.impl;

import org.kushinae.olapu.repository.entities.DatasourceConfigure;
import org.kushinae.olapu.repository.repository.IServiceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Repository
public interface DatasourceConfigureRepository extends IServiceRepository<DatasourceConfigure, Long> {

    List<DatasourceConfigure> searchByDatasourceId(Long datasourceId);

}
