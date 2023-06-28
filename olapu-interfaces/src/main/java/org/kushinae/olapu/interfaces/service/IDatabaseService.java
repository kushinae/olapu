package org.kushinae.olapu.interfaces.service;

import org.kushinae.yone.core.rdbms.Column;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IDatabaseService extends IService {
    List<String> databases(Long datasourceId, String uid, Boolean allDatabase);

    List<String> tables(Long datasourceId, String uid, String database);

    List<Column> columns(Long datasourceId, String database, String table, String uid);

    String preview(Long datasourceId, String database, String table);
}
