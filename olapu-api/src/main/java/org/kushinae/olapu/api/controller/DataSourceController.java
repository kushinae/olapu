package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.convert.DatasourceConvert;
import org.kushinae.olapu.interfaces.service.IDatasourceService;
import org.kushinae.olapu.interfaces.controller.AbstractController;
import org.kushinae.olapu.interfaces.controller.datasource.IDatasourceController;
import org.kushinae.olapu.interfaces.pojo.api.SearchPayload;
import org.kushinae.olapu.interfaces.pojo.api.datasource.CreatePayload;
import org.kushinae.olapu.interfaces.vo.Page;
import org.kushinae.olapu.interfaces.vo.datasource.DatasourceInfo;
import org.kushinae.olapu.repository.entities.Datasource;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
public class DataSourceController extends AbstractController implements IDatasourceController {

    @Resource
    IDatasourceService datasourceService;

    @Override
    public Long create(CreatePayload createPayload) {
        Datasource entity = DatasourceConvert.INSTANCE.create2Entity(createPayload);
        entity.setUid(authorization.getUid());
        return getService().create(entity);
    }

    @Override
    public List<DatasourceType> supports() {
        return getService().supports();
    }

    @Override
    public Page<DatasourceInfo> search(Integer current, Integer queryCount, String query) {
        SearchPayload<String> search = SearchPayload
                .builder(String.class)
                .current(current)
                .queryCount(queryCount)
                .query(query)
                .uid(authorization.getUid())
                .build();
        org.springframework.data.domain.Page<Datasource> page = getService().search(search);
        return Page
                .builder(DatasourceInfo.class)
                .current(search.getCurrent())
                .total(page.getTotalElements())
                .queryCount(search.getQueryCount())
                .records(DatasourceConvert.INSTANCE.entities2Infos(page.get().toList()))
                .build();
    }

    @Override
    public IDatasourceService getService() {
        return datasourceService;
    }

}
