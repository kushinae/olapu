package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.convert.TemplateConvert;
import org.kushinae.olapu.api.pojo.api.template.Create;
import org.kushinae.olapu.api.service.TemplateService;
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
public class TemplateController {

    @Resource
    private TemplateService templateService;

    @PostMapping
    Long created(@RequestBody Create payload) {
        return templateService.create(TemplateConvert.INSTANCE.toEntity(payload));
    }

}
