package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.service.ResourceService;
import org.kushinae.olapu.api.vo.resource.EditResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Resource
    ResourceService resourceService;

    @PostMapping
    Long create(@RequestBody EditResource payload) {
        return resourceService.create(payload);
    }

}
