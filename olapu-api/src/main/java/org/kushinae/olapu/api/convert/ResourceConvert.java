package org.kushinae.olapu.api.convert;

import org.kushinae.olapu.api.vo.resource.EditResource;
import org.kushinae.olapu.repository.entities.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Mapper
public interface ResourceConvert {

    ResourceConvert INSTANCE = Mappers.getMapper(ResourceConvert.class);
    Resource toEntity(EditResource editResource);

}
