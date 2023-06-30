package org.kushinae.olapu.api.components;

import org.kushinae.olapu.core.enums.DatasourceType;
import org.kushinae.yone.core.client.IClient;
import org.kushinae.yone.core.properties.Properties;
import org.kushinae.yone.core.rdbms.Column;

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

    List<String> tables(Long datasourceId, String database);

    List<Column> columnDetails(Long datasourceId, String database, String table);

    <R> R executeWithSingleResult(Long datasourceId, String database, String table, String script, Class<R> resultClass);

    DatasourceType getType();

    Properties getProperties(Long datasourceId);

}
