package org.kushinae.olapu.api.service;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface DatabaseService {
    List<String> databases(Long datasourceId, String uid, Boolean allDatabase);

    List<String> tables(Long datasourceId, String uid, String database);
}
