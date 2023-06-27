package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.components.ComponentFactory;
import org.kushinae.olapu.interfaces.service.IDatabaseService;
import org.kushinae.yone.commons.model.pojo.rdbms.Column;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class IDatabaseServiceImpl implements IDatabaseService {

    @Resource
    ComponentFactory componentFactory;

    @Override
    public List<String> databases(Long datasourceId, String uid, Boolean allDatabase) {
        return componentFactory.getDatasourceComponent(datasourceId).databases(datasourceId, uid, !allDatabase);
    }

    @Override
    public List<String> tables(Long datasourceId, String uid, String database) {
        return componentFactory.getDatasourceComponent(datasourceId).tables(datasourceId, uid, database);
    }

    @Override
    public List<Column> columns(Long datasourceId, String database, String table, String uid) {
        return componentFactory.getDatasourceComponent(datasourceId).columnDetails(datasourceId, uid, database, table);
    }
}
