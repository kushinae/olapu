package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.convert.DatasourceConfigureConvert;
import org.kushinae.olapu.api.service.DatasourceConfigureService;
import org.kushinae.olapu.interfaces.controller.AbstractController;
import org.kushinae.olapu.interfaces.controller.datasource.IDatasourceConfigureController;
import org.kushinae.olapu.interfaces.pojo.api.datasource.configure.EditConfigurePayload;
import org.kushinae.olapu.interfaces.vo.datasource.configure.Configure;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
public class DatasourceConfigureController extends AbstractController implements IDatasourceConfigureController {

    @Resource
    DatasourceConfigureService datasourceConfigureService;

    @Override
    public List<Configure> template(DatasourceType type) {
        return DatasourceConfigureConvert.INSTANCE.entities2Configures(datasourceConfigureService.template(type));
    }

    @Override
    public List<Configure> configure(EditConfigurePayload payload) {
        return DatasourceConfigureConvert.INSTANCE.entities2Configures(datasourceConfigureService.configure(payload.getDatasourceId(), authorization.getUid(), DatasourceConfigureConvert.INSTANCE.configures2Entities(payload.getConfigures())));
    }

    @Override
    public List<Configure> getConfigures(Long datasourceId) {
        return DatasourceConfigureConvert.INSTANCE.entities2Configures(datasourceConfigureService.configures(datasourceId));
    }

}
