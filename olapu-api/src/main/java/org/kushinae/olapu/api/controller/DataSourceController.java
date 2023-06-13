package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.authorization.Authorization;
import org.kushinae.olapu.api.convert.DatasourceConvert;
import org.kushinae.olapu.api.pojo.api.datasource.CreatePayload;
import org.kushinae.olapu.api.service.DatasourceService;
import org.kushinae.olapu.repository.entities.Datasource;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.kushinae.yone.client.IClient;
import org.kushinae.yone.client.Yone;
import org.kushinae.yone.commons.model.properties.mysql.MySQLProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/databases")
    public List<String> databases() {
        MySQLProperties properties = new MySQLProperties();
        properties.setPort(3306);
        properties.setUsername("root");
        properties.setPassword("123456");
        properties.setIp("127.0.0.1");
        IClient client = Yone
                .client(DatasourceType.MYSQL.getYoneCode())
                .build(properties);
        return client.databases(true);
    }

    @PostMapping
    public Long create(@RequestBody CreatePayload createPayload) {
        Datasource entity = DatasourceConvert.INSTANCE.create2Entity(createPayload);
        entity.setUid(authorization.getUid());
        return datasourceService.create(entity);
    }

}
