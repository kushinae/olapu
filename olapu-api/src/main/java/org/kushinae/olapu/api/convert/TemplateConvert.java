package org.kushinae.olapu.api.convert;

import org.kushinae.olapu.api.pojo.api.template.CreatePayload;
import org.kushinae.olapu.repository.entities.Template;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Mapper
public interface TemplateConvert {

    TemplateConvert INSTANCE = Mappers.getMapper(TemplateConvert.class);

    Template toEntity(CreatePayload createPayload);

}
