package org.kushinae.olapu.api.components.support;

import org.kushinae.olapu.api.components.RDBMSDatasourceComponent;
import org.kushinae.olapu.api.pojo.lang.DatasourceConfigureMapping;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.kushinae.yone.commons.model.properties.Properties;
import org.kushinae.yone.commons.model.properties.mysql.MySQLProperties;
import org.springframework.stereotype.Component;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Component
public class MySQLComponent extends RDBMSDatasourceComponent {
    @Override
    public DatasourceType getType() {
        return DatasourceType.MYSQL;
    }

    @Override
    public Properties getProperties(Long datasourceId) {
        DatasourceConfigureMapping mapping = datasourceConfigureService.load2Mapping(datasourceId);
        MySQLProperties properties = new MySQLProperties();
        properties.setIp(mapping.getHost());
        properties.setPassword(mapping.getPassword());
        properties.setPort(mapping.getPort());
        properties.setUsername(mapping.getUsername());
        return properties;
    }
}
