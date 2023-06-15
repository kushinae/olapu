package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.authorization.Authorization;
import org.kushinae.olapu.api.convert.DatasourceConvert;
import org.kushinae.olapu.api.pojo.api.datasource.CreatePayload;
import org.kushinae.olapu.api.service.DatasourceService;
import org.kushinae.olapu.repository.entities.Datasource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/datasource")
public class DataSourceController {

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

}
