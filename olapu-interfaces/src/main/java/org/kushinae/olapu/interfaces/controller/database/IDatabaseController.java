package org.kushinae.olapu.interfaces.controller.database;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kushinae.olapu.interfaces.controller.IController;
import org.kushinae.olapu.interfaces.service.IDatabaseService;
import org.kushinae.yone.core.rdbms.Column;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RequestMapping("/database")
@Tag(name = "数据库操作控制器", description = "控制者用户操作数据库的相关信息，如：获取所有库、表、字段等与数据库相关的信息。")
public interface IDatabaseController extends IController {

    @GetMapping("/databases")
    @Operation(summary = "通过数据源获取数据库列表")
    List<String> database(@Parameter(required = true, example = "1") @RequestParam("datasource_id") Long datasourceId,
                          @Parameter(description = "如果为true则不会忽略默认数据库", example = "false") @RequestParam(value = "all", required = false, defaultValue = "false") Boolean allDatabase);

    @GetMapping("/tables")
    @Operation(summary = "通过数据源ID以及库名获取表列表")
    List<String> tables(@Parameter(required = true, example = "1") @RequestParam("datasource_id") Long datasourceId,
                        @Parameter(description = "如果为空使用数据源配置的数据库，如果该参数和数据源配置的数据库都为空则抛出异常400") @RequestParam(value = "database", required = false) String database);

    @GetMapping("/columns/detail")
    @Operation(summary = "通过数据源ID以及库名称和表名称获取字段详情")
    List<Column> columns(@Parameter(required = true, example = "1") @RequestParam("datasource_id") Long datasourceId,
                         @Parameter(description = "如果为空使用数据源配置的数据库，如果该参数和数据源配置的数据库都为空则抛出异常400", example = "olapu") @RequestParam(value = "database", required = false) String database,
                         @Parameter(required = true, example = "t_user") @RequestParam("table") String table);

    @GetMapping("/preview")
    @Operation(summary = "预览数据")
    String preview(@Parameter(required = true, example = "1") @RequestParam("datasource_id") Long datasourceId,
                         @Parameter(description = "如果为空使用数据源配置的数据库，如果该参数和数据源配置的数据库都为空则抛出异常400", example = "olapu") @RequestParam(value = "database", required = false) String database,
                         @Parameter(required = true, example = "t_user") @RequestParam("table") String table);


    @Override
    IDatabaseService getService();
}
