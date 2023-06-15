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

    IClient buildClient(Properties properties, Long datasourceId);

    List<String> databases(Long datasourceId);

    List<String> databases(Long datasourceId, boolean skipDefault);

    DatasourceType getType();

    Properties getProperties(Long datasourceId);

}
