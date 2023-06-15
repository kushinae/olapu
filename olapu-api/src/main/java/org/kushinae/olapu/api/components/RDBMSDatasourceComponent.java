package org.kushinae.olapu.api.components;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.service.DatasourceConfigureService;
import org.kushinae.olapu.api.service.DatasourceService;
import org.kushinae.yone.client.IClient;
import org.kushinae.yone.client.Yone;
import org.kushinae.yone.commons.model.properties.Properties;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class RDBMSDatasourceComponent implements DatasourceComponent {

    @Resource
    protected DatasourceConfigureService datasourceConfigureService;

    @Resource
    protected DatasourceService datasourceService;

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
}
