package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.authorization.Authorization;
import org.kushinae.olapu.api.convert.ResourceConvert;
import org.kushinae.olapu.api.pojo.api.resource.Detail;
import org.kushinae.olapu.api.service.ResourceService;
import org.kushinae.olapu.api.vo.resource.EditResource;
import org.kushinae.olapu.repository.enums.ResourceCategory;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class ResourceController extends AbstractController {

    @Resource
    ResourceService resourceService;

    @Resource
    Authorization authorization;

    @PostMapping
    Long create(@RequestBody EditResource payload) {
        org.kushinae.olapu.repository.entities.Resource entity = ResourceConvert.INSTANCE.toEntity(payload);
        entity.setUid(authorization.getUid());
        return resourceService.create(entity);
    }

    @GetMapping
    List<Detail> getResources(@RequestParam(value = "parent_id", defaultValue = "-1", required = false) Long parentId,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam("category") ResourceCategory category) {
        return ResourceConvert.INSTANCE.toDetails(resourceService.getResources(parentId, name, authorization.getUid(), category));
    }

    @DeleteMapping
    void deleteResource(@RequestParam("id") Long id) {
        resourceService.deleteResource(id, authorization.getUid());
    }

}
