package org.kushinae.olapu.interfaces.controller.datasource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kushinae.olapu.interfaces.controller.IController;
import org.kushinae.olapu.interfaces.pojo.api.datasource.configure.EditConfigurePayload;
import org.kushinae.olapu.interfaces.service.IDatasourceConfigureService;
import org.kushinae.olapu.interfaces.vo.datasource.configure.Configure;
import org.kushinae.olapu.repository.enums.DatasourceType;
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
@RequestMapping("/datasource/configure")
@Tag(name = "数据源配置管理控制器", description = "该控制器用以管理数据源的配置管理")
public interface IDatasourceConfigureController extends IController {

    @GetMapping("/template")
    @Operation(summary = "获取数据源配置模版")
    List<Configure> template(@Parameter(description = "数据源类型") @RequestParam("type") DatasourceType type);

    @PostMapping
    @Operation(summary = "通过数据源ID修改数据源配置")
    List<Configure> configure(@RequestBody EditConfigurePayload payload);

    @GetMapping
    @Operation(summary = "通过数据源ID获取数据源配置")
    List<Configure> getConfigures(@Parameter(description = "数据源主键ID") @RequestParam("datasource_id") Long datasourceId);

    @Override
    IDatasourceConfigureService getService();
}
