package org.kushinae.olapu.interfaces.controller.datasource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kushinae.olapu.interfaces.controller.IController;
import org.kushinae.olapu.interfaces.pojo.api.datasource.CreatePayload;
import org.kushinae.olapu.interfaces.service.IDatasourceService;
import org.kushinae.olapu.interfaces.vo.Page;
import org.kushinae.olapu.interfaces.vo.datasource.DatasourceInfo;
import org.kushinae.olapu.core.enums.DatasourceType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RequestMapping("/datasource")
@Tag(name = "数据源管理控制器", description = "该控制器用于操作数据源相关信息")
public interface IDatasourceController extends IController {

    @PostMapping
    @Operation(summary = "创建数据源")
    Long create(@RequestBody CreatePayload createPayload);

    @GetMapping("/supports")
    @Operation(summary = "获取当前支持的所有数据源类型")
    List<DatasourceType> supports();

    @GetMapping("/search")
    @Operation(summary = "获取当前支持的所有数据源类型")
    Page<DatasourceInfo> search(@Parameter(description = "当前页码 默认为1") @RequestParam(value = "current", defaultValue = "1", required = false) Integer current,
                                @Parameter(description = "每页查询条目 默认为10") @RequestParam(value = "query_count", defaultValue = "10") Integer queryCount,
                                @Parameter(description = "查询条件值 不为空时将使用该值和数据源名称模糊匹配") @RequestParam(value = "q", required = false) String query);

    @Override
    IDatasourceService getService();
}
