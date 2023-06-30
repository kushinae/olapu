package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.interfaces.service.ITemplateService;
import org.kushinae.olapu.core.util.AbstractAssert;
import org.kushinae.olapu.repository.entities.Template;
import org.kushinae.olapu.repository.repository.impl.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class ITemplateServiceImpl implements ITemplateService {

    @Resource
    TemplateRepository templateRepository;

    @Override
    public TemplateRepository getRepository() {
        return templateRepository;
    }

    @Override
    public Template queryById(Long id) {
        return getRepository().findById(id).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.TEMPLATE_DOES_NOT_EXIST.getCode()));
    }

    @Override
    public Long create(Template template) {
        Template queryTemplate = getRepository().searchBySourceAndTypeAndModelAndUid(template.getSource(), template.getType(), template.getModel(), template.getUid());
        AbstractAssert.isNull(queryTemplate, ErrorMessage.TEMPLATE_DATA_ALREADY_EXISTS);
        queryTemplate = getRepository().searchByNameAndUid(template.getName(), template.getUid());
        AbstractAssert.isNull(queryTemplate, ErrorMessage.TEMPLATE_NAME_ALREADY_EXISTS);
        template.setCreateAt(new Date());
        template.setModifiedAt(new Date());
        template.setDeleted(false);
        return getRepository().save(template).getId();
    }
}
