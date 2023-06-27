package org.kushinae.olapu.api.components;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.interfaces.service.IDatasourceConfigureService;
import org.kushinae.olapu.interfaces.service.IDatasourceService;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.api.util.StringUtils;
import org.kushinae.yone.client.IClient;
import org.kushinae.yone.client.Yone;
import org.kushinae.yone.commons.model.pojo.rdbms.Column;
import org.kushinae.yone.commons.model.properties.Properties;
import org.kushinae.yone.commons.model.properties.RDBProperties;

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
    public IClient buildClient(Properties properties, String uid, Long datasourceId) {
        return Yone.client(getType().getYoneCode()).build(getProperties(datasourceId, uid));
    }

    @Override
    public List<String> databases(Long datasourceId, String uid) {
        return buildClient(getProperties(datasourceId, uid), uid, datasourceId).databases(false);
    }

    @Override
    public List<String> databases(Long datasourceId, String uid, boolean skipDefault) {
        return buildClient(getProperties(datasourceId, uid), uid, datasourceId).databases(skipDefault);
    }

    @Override
    public List<String> tables(Long datasourceId, String uid, String database) {
        RDBProperties properties = (RDBProperties) getProperties(datasourceId, uid);
        AbstractAssert.anyHasText(Stream.of(database, properties.getDatabase()).toList(), ErrorMessage.DATABASE_CANNOT_BE_EMPTY);
        IClient client = buildClient(properties, uid, datasourceId);
        database = StringUtils.hasText(database) ? database : properties.getDatabase();
        return client.tables(database);
    }

    @Override
    public List<Column> columnDetails(Long datasourceId, String uid, String database, String table) {
        RDBProperties properties = (RDBProperties) getProperties(datasourceId, uid);
        AbstractAssert.anyHasText(Stream.of(database, properties.getDatabase()).toList(), ErrorMessage.DATABASE_CANNOT_BE_EMPTY);
        AbstractAssert.hasText(table, ErrorMessage.TABLE_CANNOT_BE_EMPTY);
        IClient client = buildClient(properties, uid, datasourceId);
        database = StringUtils.hasText(database) ? database : properties.getDatabase();
        return client.columnDetails(database, table);
    }
}
