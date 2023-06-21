package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.authorization.Authorization;
import org.kushinae.olapu.api.convert.TemplateConvert;
import org.kushinae.olapu.api.pojo.api.template.CreatePayload;
import org.kushinae.olapu.api.service.TemplateService;
import org.kushinae.olapu.repository.entities.Template;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Validated
@RestController
@RequestMapping("/template")
public class TemplateController extends AbstractController {

    @Resource
    private TemplateService templateService;

    @Resource
    private Authorization authorization;

    @PostMapping
    Long created(@RequestBody CreatePayload payload) {
        Template template = TemplateConvert.INSTANCE.toEntity(payload);
        template.setUid(authorization.getUid());
        return templateService.create(template);
    }

}
