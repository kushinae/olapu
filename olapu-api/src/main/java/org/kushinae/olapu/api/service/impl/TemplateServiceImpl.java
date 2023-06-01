package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.api.service.TemplateService;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.repository.entities.Template;
import org.kushinae.olapu.repository.repository.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    @Resource
    TemplateRepository templateRepository;

    @Override
    public TemplateRepository getRepository() {
        return templateRepository;
    }

    @Override
    public Long create(Template template) {
        Template queryTemplate = getRepository().searchBySourceAndTypeAndModel(template.getSource(), template.getType(), template.getModel());
        AbstractAssert.isNull(queryTemplate, ErrorMessage.TEMPLATE_DATA_ALREADY_EXISTS);

        queryTemplate = getRepository().searchByName(template.getName());
        AbstractAssert.isNull(queryTemplate, ErrorMessage.TEMPLATE_NAME_ALREADY_EXISTS);
        template.setCreateAt(new Date());
        template.setModifiedAt(new Date());
        template.setDeleted(false);
        return getRepository().save(template).getId();
    }
}
