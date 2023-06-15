package org.kushinae.olapu.api.components;

import org.kushinae.olapu.repository.enums.DatasourceType;
import org.kushinae.yone.client.IClient;
import org.kushinae.yone.commons.model.properties.Properties;

import java.util.List;

/**
 * 数据源组件API
 *
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface DatasourceComponent {

    IClient buildClient(Properties properties, String uid, Long datasourceId);

    List<String> databases(Long datasourceId, String uid);

    List<String> databases(Long datasourceId, String uid, boolean skipDefault);

    List<String> tables(Long datasourceId, String uid, String database);

    DatasourceType getType();

    Properties getProperties(Long datasourceId, String uid);

}
