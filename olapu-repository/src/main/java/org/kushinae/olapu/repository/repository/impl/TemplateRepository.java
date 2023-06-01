package org.kushinae.olapu.repository.repository.impl;

import org.kushinae.olapu.repository.entities.Template;
import org.kushinae.olapu.repository.enums.TemplateModel;
import org.kushinae.olapu.repository.enums.TemplateSource;
import org.kushinae.olapu.repository.enums.TemplateType;
import org.kushinae.olapu.repository.repository.IServiceRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Repository
public interface TemplateRepository extends IServiceRepository<Template, Long> {

    Template searchBySourceAndTypeAndModel(TemplateSource source, TemplateType typ, TemplateModel model);

    Template searchByName(String name);

}
