package org.kushinae.olapu.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.kushinae.olapu.api.authorization.Authorization;
import org.kushinae.olapu.api.convert.DatasourceConfigureConvert;
import org.kushinae.olapu.api.pojo.api.datasource.configure.EditConfigurePayload;
import org.kushinae.olapu.api.service.DatasourceConfigureService;
import org.kushinae.olapu.api.vo.datasource.configure.Configure;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/datasource/configure")
@Tag(name = "数据源配置管理控制器", description = "该控制器用以管理数据源的配置管理")
public class DatasourceConfigureController extends AbstractController {

    @Resource
    DatasourceConfigureService datasourceConfigureService;

    @Resource
    Authorization authorization;

    @GetMapping("/template")
    @Operation(summary = "获取数据源配置模版")
    public List<Configure> template(@Parameter(description = "数据源类型") @RequestParam("type") DatasourceType type) {
        return DatasourceConfigureConvert.INSTANCE.entities2Configures(datasourceConfigureService.template(type));
    }

    @PostMapping
    public List<Configure> configure(@RequestBody EditConfigurePayload payload) {
        return DatasourceConfigureConvert.INSTANCE.entities2Configures(datasourceConfigureService.configure(payload.getDatasourceId(), authorization.getUid(), DatasourceConfigureConvert.INSTANCE.configures2Entities(payload.getConfigures())));
    }

    @GetMapping
    public List<Configure> getConfigures(@RequestParam("datasource_id") Long datasourceId) {
        return DatasourceConfigureConvert.INSTANCE.entities2Configures(datasourceConfigureService.configures(datasourceId));
    }

}
