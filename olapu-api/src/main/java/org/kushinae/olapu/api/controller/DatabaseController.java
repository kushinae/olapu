package org.kushinae.olapu.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "数据库操作控制器", description = "控制者用户操作数据库的相关信息，如：获取所有库、表、字段等与数据库相关的信息。")
public class DatabaseController extends AbstractController {

    @Resource
    DatabaseService databaseService;

    @Resource
    Authorization authorization;

    @GetMapping("/databases")
    @Operation(summary = "通过数据源获取数据库列表")
    public List<String> database(@Parameter(required = true, example = "1") @RequestParam("datasource_id") Long datasourceId,
                                 @Parameter(description = "如果为true则不会忽略默认数据库", example = "false") @RequestParam(value = "all", required = false, defaultValue = "false") Boolean allDatabase) {
        return databaseService.databases(datasourceId, authorization.getUid(), allDatabase);
    }

    @GetMapping("/tables")
    @Operation(summary = "通过数据源ID以及库名获取表列表")
    public List<String> tables(@Parameter(required = true, example = "1") @RequestParam("datasource_id") Long datasourceId,
                               @Parameter(description = "如果为空使用数据源配置的数据库，如果该参数和数据源配置的数据库都为空则抛出异常400") @RequestParam(value = "database", required = false) String database) {
        return databaseService.tables(datasourceId, authorization.getUid(), database);
    }

    @GetMapping("/columns/detail")
    @Operation(summary = "通过数据源ID以及库名称和表名称获取字段详情")
    public List<Column> columns(@Parameter(required = true, example = "1") @RequestParam("datasource_id") Long datasourceId,
                                @Parameter(description = "如果为空使用数据源配置的数据库，如果该参数和数据源配置的数据库都为空则抛出异常400", example = "olapu") @RequestParam(value = "database", required = false) String database,
                                @Parameter(required = true, example = "t_user") @RequestParam("table") String table) {
        return databaseService.columns(datasourceId, database, table, authorization.getUid());
    }

}
