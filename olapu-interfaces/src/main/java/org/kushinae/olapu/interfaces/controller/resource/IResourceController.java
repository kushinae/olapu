package org.kushinae.olapu.interfaces.controller.resource;

import org.kushinae.olapu.interfaces.controller.IController;
import org.kushinae.olapu.interfaces.pojo.api.resource.Detail;
import org.kushinae.olapu.interfaces.vo.resource.EditResource;
import org.kushinae.olapu.repository.enums.ResourceCategory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RequestMapping("/resource")
public interface IResourceController extends IController {

    @PostMapping
    Long create(@RequestBody EditResource payload);

    @GetMapping
    List<Detail> getResources(@RequestParam(value = "parent_id", defaultValue = "-1", required = false) Long parentId,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam("category") ResourceCategory category);

    @DeleteMapping
    void deleteResource(@RequestParam("id") Long id);
}
