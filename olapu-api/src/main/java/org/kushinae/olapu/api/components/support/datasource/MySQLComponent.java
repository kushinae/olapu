package org.kushinae.olapu.api.components.support.datasource;

import org.kushinae.olapu.api.components.RDBMSDatasourceComponent;
import org.kushinae.olapu.interfaces.pojo.lang.DatasourceConfigureMapping;
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
    public Properties getProperties(Long datasourceId, String uid) {
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
