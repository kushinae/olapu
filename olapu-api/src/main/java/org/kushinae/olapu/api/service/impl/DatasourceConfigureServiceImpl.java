package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.api.service.DatasourceConfigureService;
import org.kushinae.olapu.api.service.DatasourceService;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.api.util.CollectionUtils;
import org.kushinae.olapu.interfaces.pojo.lang.DatasourceConfigureMapping;
import org.kushinae.olapu.repository.entities.Datasource;
import org.kushinae.olapu.repository.entities.DatasourceConfigure;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.kushinae.olapu.repository.repository.impl.DatasourceConfigureRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class DatasourceConfigureServiceImpl implements DatasourceConfigureService {

    @Resource
    DatasourceService datasourceService;

    @Resource
    DatasourceConfigureRepository datasourceConfigureRepository;

    @Override
    public DatasourceConfigureRepository getRepository() {
        return datasourceConfigureRepository;
    }

    @Override
    public List<DatasourceConfigure> configures(Long datasourceId) {
        Datasource datasource = datasourceService.queryById(datasourceId);
        AbstractAssert.notNull(datasource, ErrorMessage.DATASOURCE_DOES_NOT_EXIST);
        return getRepository().searchByDatasourceId(datasourceId);
    }

    @Override
    public List<DatasourceConfigure> template(DatasourceType type) {
        Datasource datasource = datasourceService.queryTemplate(type);
        AbstractAssert.notNull(datasource, ErrorMessage.DATASOURCE_DOES_NOT_EXIST);
        return getRepository().searchByDatasourceId(datasource.getId());
    }

    @Override
    public List<DatasourceConfigure> configure(Long datasourceId, String uid, List<DatasourceConfigure> configures) {
        List<DatasourceConfigure> datasourceConfigures = configures(datasourceId);
        AbstractAssert.isEmpty(datasourceConfigures, ErrorMessage.DUPLICATE_DATA_SOURCE_CONFIGURATION_ITEMS);

        Map<String, Object> map = new HashMap<>();
        configures.forEach(e -> {
            AbstractAssert.isNull(map.get(e.getKey()), ErrorMessage.DUPLICATE_DATA_SOURCE_CONFIGURATION_ITEMS);
            e.setCreateAt(new Date());
            e.setModifiedAt(new Date());
            e.setDeleted(false);
            e.setDatasourceId(datasourceId);
            map.put(e.getKey(), e.getValue());
        });

        return StreamSupport.stream(getRepository().saveAll(configures).spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public DatasourceConfigureMapping load2Mapping(List<DatasourceConfigure> datasourceConfigures) {
        if (CollectionUtils.isEmpty(datasourceConfigures)) {
            return new DatasourceConfigureMapping();
        }

        DatasourceConfigureMapping mapping = new DatasourceConfigureMapping();
        datasourceConfigures.forEach(e -> mapping.put(e.getKey(), e.getValue()));
        return mapping;
    }

    @Override
    public DatasourceConfigureMapping load2Mapping(Long datasourceId) {
        List<DatasourceConfigure> configures = configures(datasourceId);
        if (CollectionUtils.isEmpty(configures)) {
            return new DatasourceConfigureMapping();
        }
        return load2Mapping(configures);
    }
}
