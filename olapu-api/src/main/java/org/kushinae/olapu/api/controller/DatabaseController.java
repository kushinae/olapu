package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.authorization.Authorization;
import org.kushinae.olapu.api.service.DatabaseService;
import org.kushinae.yone.commons.model.pojo.rdbms.Column;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/database")
public class DatabaseController {

    @Resource
    DatabaseService databaseService;

    @Resource
    Authorization authorization;

    @GetMapping("/databases")
    public List<String> database(@RequestParam("datasource_id") Long datasourceId,
                                 @RequestParam(value = "all", required = false, defaultValue = "false") Boolean allDatabase) {
        return databaseService.databases(datasourceId, authorization.getUid(), allDatabase);
    }

    @GetMapping("/tables")
    public List<String> tables(@RequestParam("datasource_id") Long datasourceId,
                               @RequestParam(value = "database", required = false) String database) {
        return databaseService.tables(datasourceId, authorization.getUid(), database);
    }

    @GetMapping("/columns/detail")
    public List<Column> columns(@RequestParam("datasource_id") Long datasourceId,
                                @RequestParam(value = "database", required = false) String database,
                                @RequestParam("table") String table) {
        return databaseService.columns(datasourceId, database, table, authorization.getUid());
    }

}
