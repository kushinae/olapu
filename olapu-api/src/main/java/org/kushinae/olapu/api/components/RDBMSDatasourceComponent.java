package org.kushinae.olapu.api.components;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.interfaces.service.IDatasourceConfigureService;
import org.kushinae.olapu.interfaces.service.IDatasourceService;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.api.util.StringUtils;
import org.kushinae.yone.core.client.IClient;
import org.kushinae.yone.core.client.Yone;
import org.kushinae.yone.core.properties.Properties;
import org.kushinae.yone.core.properties.RDBProperties;
import org.kushinae.yone.core.rdbms.Column;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class RDBMSDatasourceComponent implements DatasourceComponent {

    @Resource
    protected IDatasourceConfigureService IDatasourceConfigureService;

    @Resource
    protected IDatasourceService IDatasourceService;

    @Override
    public IClient buildClient(Properties properties, Long datasourceId) {
        return Yone.client(getType().getYoneCode()).build(getProperties(datasourceId));
    }

    @Override
    public List<String> databases(Long datasourceId) {
        return buildClient(getProperties(datasourceId), datasourceId).databases(false);
    }

    @Override
    public List<String> databases(Long datasourceId, boolean skipDefault) {
        return buildClient(getProperties(datasourceId), datasourceId).databases(skipDefault);
    }

    @Override
    public List<String> tables(Long datasourceId, String database) {
        RDBProperties properties = (RDBProperties) getProperties(datasourceId);
        AbstractAssert.anyHasText(Stream.of(database, properties.getDatabase()).toList(), ErrorMessage.DATABASE_CANNOT_BE_EMPTY);
        IClient client = buildClient(properties, datasourceId);
        database = StringUtils.hasText(database) ? database : properties.getDatabase();
        return client.tables(database);
    }

    @Override
    public List<Column> columnDetails(Long datasourceId, String database, String table) {
        RDBProperties properties = (RDBProperties) getProperties(datasourceId);
        AbstractAssert.anyHasText(Stream.of(database, properties.getDatabase()).toList(), ErrorMessage.DATABASE_CANNOT_BE_EMPTY);
        AbstractAssert.hasText(table, ErrorMessage.TABLE_CANNOT_BE_EMPTY);
        IClient client = buildClient(properties, datasourceId);
        database = StringUtils.hasText(database) ? database : properties.getDatabase();
        return client.columnDetails(database, table);
    }

    @Override
    public <R> R executeWithSingleResult(Long datasourceId, String database, String table, String script, Class<R> resultClass) {
        RDBProperties properties = (RDBProperties) getProperties(datasourceId);
        AbstractAssert.anyHasText(Stream.of(database, properties.getDatabase()).toList(), ErrorMessage.DATABASE_CANNOT_BE_EMPTY);
        AbstractAssert.hasText(table, ErrorMessage.TABLE_CANNOT_BE_EMPTY);
        IClient client = buildClient(properties, datasourceId);
        return client.executeQueryWithSingle(script, resultClass);
    }
}
