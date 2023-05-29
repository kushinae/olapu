package org.kushinae.olapu.repository.repository;

import org.kushinae.olapu.repository.entities.Template;
import org.kushinae.olapu.repository.enums.TemplateModel;
import org.kushinae.olapu.repository.enums.TemplateSource;
import org.kushinae.olapu.repository.enums.TemplateType;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Repository
public interface TemplateRepository extends ListPagingAndSortingRepository<Template, Long> {

    Template searchBySourceAndTypeAndModel(TemplateSource source, TemplateType typ, TemplateModel model);

    Template searchByName(String name);

    Template save(Template template);
}
