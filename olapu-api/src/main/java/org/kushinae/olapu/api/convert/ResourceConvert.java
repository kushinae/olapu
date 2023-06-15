package org.kushinae.olapu.api.convert;

import org.kushinae.olapu.api.pojo.api.resource.Detail;
import org.kushinae.olapu.api.vo.resource.EditResource;
import org.kushinae.olapu.repository.entities.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResourceConvert {

    ResourceConvert INSTANCE = Mappers.getMapper(ResourceConvert.class);
    Resource toEntity(EditResource editResource);

    Detail toDetail(Resource resource);

    List<Detail> toDetails(List<Resource> resources);

}
