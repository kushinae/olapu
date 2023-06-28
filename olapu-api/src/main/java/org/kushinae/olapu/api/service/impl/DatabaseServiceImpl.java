package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.heimerdinger.core.utils.JacksonUtils;
import org.kushinae.olapu.api.components.ComponentFactory;
import org.kushinae.olapu.interfaces.service.IDatabaseService;
import org.kushinae.olapu.repository.entities.Job;
import org.kushinae.yone.core.rdbms.Column;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class DatabaseServiceImpl implements IDatabaseService {

    @Resource
    ComponentFactory componentFactory;

    @Override
    public List<String> databases(Long datasourceId, String uid, Boolean allDatabase) {
        return componentFactory.getDatasourceComponent(datasourceId).databases(datasourceId, !allDatabase);
    }

    @Override
    public List<String> tables(Long datasourceId, String uid, String database) {
        return componentFactory.getDatasourceComponent(datasourceId).tables(datasourceId, database);
    }

    @Override
    public List<Column> columns(Long datasourceId, String database, String table, String uid) {
        return componentFactory.getDatasourceComponent(datasourceId).columnDetails(datasourceId, database, table);
    }

    @Override
    public String preview(Long datasourceId, String database, String table) {
        return JacksonUtils.toJsonString(componentFactory.getDatasourceComponent(datasourceId).executeWithSingleResult(datasourceId, database, table, "select * from t_job", Job.class));
    }
}
