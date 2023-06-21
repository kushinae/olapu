package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.authorization.Authorization;
import org.kushinae.olapu.api.convert.DatasourceConvert;
import org.kushinae.olapu.api.pojo.api.SearchPayload;
import org.kushinae.olapu.api.pojo.api.datasource.CreatePayload;
import org.kushinae.olapu.api.service.DatasourceService;
import org.kushinae.olapu.api.vo.Page;
import org.kushinae.olapu.api.vo.datasource.DatasourceInfo;
import org.kushinae.olapu.repository.entities.Datasource;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/datasource")
public class DataSourceController extends AbstractController {

    @Resource
    DatasourceService datasourceService;

    @Resource
    Authorization authorization;

    @PostMapping
    public Long create(@RequestBody CreatePayload createPayload) {
        Datasource entity = DatasourceConvert.INSTANCE.create2Entity(createPayload);
        entity.setUid(authorization.getUid());
        return datasourceService.create(entity);
    }

    @GetMapping("/supports")
    public List<DatasourceType> supports() {
        return datasourceService.supports();
    }

    @GetMapping("/search")
    public Page<DatasourceInfo> search(@RequestParam(value = "current", defaultValue = "1", required = false) Integer current,
                                       @RequestParam(value = "query_count", defaultValue = "10") Integer queryCount,
                                       @RequestParam(value = "q", required = false) String query) {
        SearchPayload<String> search = SearchPayload
                .builder(String.class)
                .current(current)
                .queryCount(queryCount)
                .query(query)
                .uid(authorization.getUid())
                .build();
        org.springframework.data.domain.Page<Datasource> page = datasourceService.search(search);
        return Page
                .builder(DatasourceInfo.class)
                .current(search.getCurrent())
                .total(page.getTotalElements())
                .queryCount(search.getQueryCount())
                .records(DatasourceConvert.INSTANCE.entities2Infos(page.get().toList()))
                .build();
    }

}
