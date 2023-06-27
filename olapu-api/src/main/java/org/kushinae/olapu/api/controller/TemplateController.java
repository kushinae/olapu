package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.convert.TemplateConvert;
import org.kushinae.olapu.api.service.TemplateService;
import org.kushinae.olapu.interfaces.controller.AbstractController;
import org.kushinae.olapu.interfaces.controller.template.ITemplateController;
import org.kushinae.olapu.interfaces.pojo.api.template.CreatePayload;
import org.kushinae.olapu.repository.entities.Template;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
public class TemplateController extends AbstractController implements ITemplateController {

    @Resource
    private TemplateService templateService;

    @Override
    public Long created(CreatePayload payload) {
        Template template = TemplateConvert.INSTANCE.toEntity(payload);
        template.setUid(authorization.getUid());
        return templateService.create(template);
    }

}
