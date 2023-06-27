package org.kushinae.olapu.interfaces.controller.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kushinae.olapu.interfaces.controller.IController;
import org.kushinae.olapu.interfaces.pojo.api.resource.Detail;
import org.kushinae.olapu.interfaces.service.IResourceService;
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
@Tag(name = "资源管理控制器", description = "用于对资源目录管理")
public interface IResourceController extends IController {

    @PostMapping
    @Operation(summary = "创建资源", description = "创建一个资源(文件、文件夹)")
    Long create(@RequestBody EditResource payload);

    @GetMapping
    @Operation(summary = "通过父资源获取所有一级子资源", description = "通过父资源获取所有一级子资源 这个父文件夹不应该为空并且他的type应该是directory")
    List<Detail> getResources(@Parameter(description = "父资源ID 默认取根目录") @RequestParam(value = "parent_id", defaultValue = "-1", required = false) Long parentId,
                              @Parameter(description = "需要模糊搜索的资源名称 该模糊匹配是通过传入parent_id来的所有一级子资源模糊匹配") @RequestParam(value = "name", required = false) String name,
                              @Parameter(description = "所属分类") @RequestParam("category") ResourceCategory category);

    @DeleteMapping
    @Operation(summary = "通过资源ID删除资源", description = "如果该资源为文件夹的话 那么如果还包含子资源则删除失败")
    void deleteResource(@Parameter(description = "资源id") @RequestParam("id") Long id);

    @Override
    IResourceService getService();
}
