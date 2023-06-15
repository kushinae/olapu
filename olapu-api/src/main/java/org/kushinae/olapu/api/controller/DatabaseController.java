package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.authorization.Authorization;
import org.kushinae.olapu.api.service.DatabaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/database")
public class DatabaseController {

    @Resource
    DatabaseService databaseService;

    @Resource
    Authorization authorization;

    @GetMapping("/databases")
    public List<String> database(@RequestParam("datasource_id") Long datasourceId,
                                 @RequestParam(value = "all", required = false, defaultValue = "false") Boolean allDatabase) {
        return databaseService.databases(datasourceId, authorization.getUid(), allDatabase);
    }

}
