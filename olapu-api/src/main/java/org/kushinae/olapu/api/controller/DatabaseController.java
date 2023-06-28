package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.interfaces.service.IDatabaseService;
import org.kushinae.olapu.interfaces.controller.AbstractController;
import org.kushinae.olapu.interfaces.controller.database.IDatabaseController;
import org.kushinae.yone.core.rdbms.Column;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
public class DatabaseController extends AbstractController implements IDatabaseController {

    @Resource
    private IDatabaseService databaseService;

    @Override
    public List<String> database(Long datasourceId, Boolean allDatabase) {
        return getService().databases(datasourceId, authorization.getUid(), allDatabase);
    }

    @Override
    public List<String> tables(Long datasourceId, String database) {
        return getService().tables(datasourceId, authorization.getUid(), database);
    }

    @Override
    public List<Column> columns(Long datasourceId, String database, String table) {
        return getService().columns(datasourceId, database, table, authorization.getUid());
    }

    @Override
    public String preview(Long datasourceId, String database, String table) {
        return getService().preview(datasourceId, database, table);
    }

    @Override
    public IDatabaseService getService() {
        return databaseService;
    }

}
