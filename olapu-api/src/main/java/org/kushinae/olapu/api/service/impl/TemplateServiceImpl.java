package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.exceprion.UniqueException;
import org.kushinae.olapu.api.service.TemplateService;
import org.kushinae.olapu.repository.entities.Template;
import org.kushinae.olapu.repository.repository.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

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
        if (Objects.nonNull(queryTemplate)) {
            throw new UniqueException("Repeat unique data");
        }

        queryTemplate = getRepository().searchByName(template.getName());
        if (Objects.nonNull(queryTemplate)) {
            throw new UniqueException("Repeat unique data");
        }
        template.setCreateAt(new Date());
        template.setModifiedAt(new Date());
        template.setDeleted(false);
        return getRepository().save(template).getId();
    }
}
