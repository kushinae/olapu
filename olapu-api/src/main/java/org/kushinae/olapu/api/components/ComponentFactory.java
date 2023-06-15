package org.kushinae.olapu.api.components;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.api.service.DatasourceService;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.repository.entities.Datasource;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Component
public class ComponentFactory {

    @Resource
    private List<DatasourceComponent> datasourceComponent;

    @Resource
    private DatasourceService datasourceService;

    public DatasourceComponent getDatasourceComponent(DatasourceType datasourceType) {
        for (DatasourceComponent component : datasourceComponent) {
            if (datasourceType.equals(component.getType())) {
                return component;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.UNSUPPORTED_DATASOURCE_TYPE.getCode());
    }

    public DatasourceComponent getDatasourceComponent(Datasource datasource) {
        AbstractAssert.notNull(datasource, ErrorMessage.DATASOURCE_DOES_NOT_EXIST);
        return getDatasourceComponent(datasource.getType());
    }

    public DatasourceComponent getDatasourceComponent(Long datasourceId, String uid) {
        Datasource datasource = datasourceService.queryById(datasourceId, uid);
        AbstractAssert.notNull(datasource, ErrorMessage.DATASOURCE_DOES_NOT_EXIST);
        return getDatasourceComponent(datasource.getType());
    }

}