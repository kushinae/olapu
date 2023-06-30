package org.kushinae.olapu.api.components.support.datasource;

import org.kushinae.olapu.api.components.RDBMSDatasourceComponent;
import org.kushinae.olapu.interfaces.pojo.lang.DatasourceConfigureMapping;
import org.kushinae.olapu.core.enums.DatasourceType;
import org.kushinae.yone.core.properties.Properties;
import org.kushinae.yone.core.properties.mysql.MySQLProperties;
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
        DatasourceConfigureMapping mapping = IDatasourceConfigureService.load2Mapping(datasourceId);
        MySQLProperties properties = new MySQLProperties();
        properties.host(mapping.getHost())
                .port(mapping.getPort())
                .password(mapping.getPassword())
                .username(mapping.getUsername());
        properties.database(mapping.getDatabase());
        return properties;
    }
}
