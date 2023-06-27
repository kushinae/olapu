package org.kushinae.olapu.api.service;

import org.kushinae.olapu.interfaces.pojo.api.SearchPayload;
import org.kushinae.olapu.repository.entities.Datasource;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface DatasourceService extends IRepositoryService<Datasource, Long> {
    Long create(Datasource entity);

    Datasource queryTemplate(DatasourceType type);

    Datasource queryById(Long id);

    List<DatasourceType> supports();

    Page<Datasource> search(SearchPayload<String> search);
}
