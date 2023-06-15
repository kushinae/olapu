package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.components.ComponentFactory;
import org.kushinae.olapu.api.service.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class DatabaseServiceImpl implements DatabaseService {

    @Resource
    ComponentFactory componentFactory;

    @Override
    public List<String> databases(Long datasourceId, String uid, Boolean allDatabase) {
        return componentFactory.getDatasourceComponent(datasourceId, uid).databases(datasourceId, uid, !allDatabase);
    }
}
