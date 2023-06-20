package org.kushinae.olapu.api.service;

import org.kushinae.olapu.repository.entities.Template;
import org.kushinae.olapu.repository.repository.impl.TemplateRepository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface TemplateService extends IRepositoryService<Template, Long> {
    Long create(Template template);

    @Override
    TemplateRepository getRepository();

    Template queryById(Long id);
}
