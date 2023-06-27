package org.kushinae.olapu.interfaces.controller.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kushinae.olapu.interfaces.controller.IController;
import org.kushinae.olapu.interfaces.pojo.api.template.CreatePayload;
import org.kushinae.olapu.interfaces.service.ITemplateService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Validated
@RequestMapping("/template")
@Tag(name = "模版控制器", description = "用于处理模版相关操作")
public interface ITemplateController extends IController {

    @PostMapping
    @Operation(summary = "创建模版", description = "创建一个模版")
    Long created(@RequestBody CreatePayload payload);

    @Override
    ITemplateService getService();
}
