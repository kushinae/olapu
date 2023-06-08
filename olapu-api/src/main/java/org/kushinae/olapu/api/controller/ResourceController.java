package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.annotation.AccessWhitelist;
import org.kushinae.olapu.api.convert.ResourceConvert;
import org.kushinae.olapu.api.pojo.api.resource.Detail;
import org.kushinae.olapu.api.service.ResourceService;
import org.kushinae.olapu.api.vo.resource.EditResource;
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
@RequestMapping("/resource")
public class ResourceController {

    @Resource
    ResourceService resourceService;

    @PostMapping
    Long create(@RequestBody EditResource payload) {
        return resourceService.create(payload);
    }

    @GetMapping
    @AccessWhitelist(value = false)
    List<Detail> getResources(@RequestParam(value = "parent_id", defaultValue = "-1", required = false) Long parentId,
                              @RequestParam(value = "name", required = false) String name) {
        return ResourceConvert.INSTANCE.toDetails(resourceService.getResources(parentId, name, "TLSDZ51qrUP0FhRJxs4GD8nB4Dad"));
    }

}
