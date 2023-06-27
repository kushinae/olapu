package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.convert.ResourceConvert;
import org.kushinae.olapu.api.service.ResourceService;
import org.kushinae.olapu.interfaces.controller.AbstractController;
import org.kushinae.olapu.interfaces.controller.resource.IResourceController;
import org.kushinae.olapu.interfaces.pojo.api.resource.Detail;
import org.kushinae.olapu.interfaces.vo.resource.EditResource;
import org.kushinae.olapu.repository.enums.ResourceCategory;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
public class ResourceController extends AbstractController implements IResourceController {

    @Resource
    ResourceService resourceService;

    @Override
    public Long create(EditResource payload) {
        org.kushinae.olapu.repository.entities.Resource entity = ResourceConvert.INSTANCE.toEntity(payload);
        entity.setUid(authorization.getUid());
        return resourceService.create(entity);
    }

    @Override
    public List<Detail> getResources(Long parentId, String name, ResourceCategory category) {
        return ResourceConvert.INSTANCE.toDetails(resourceService.getResources(parentId, name, authorization.getUid(), category));
    }

    @Override
    public void deleteResource(Long id) {
        resourceService.deleteResource(id, authorization.getUid());
    }

}
