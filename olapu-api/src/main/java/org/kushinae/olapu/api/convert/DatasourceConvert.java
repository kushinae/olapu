package org.kushinae.olapu.api.convert;

import org.kushinae.olapu.api.pojo.api.datasource.CreatePayload;
import org.kushinae.olapu.api.vo.datasource.DatasourceInfo;
import org.kushinae.olapu.repository.entities.Datasource;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DatasourceConvert {

    DatasourceConvert INSTANCE = Mappers.getMapper(DatasourceConvert.class);

    Datasource create2Entity(CreatePayload createPayload);

    DatasourceInfo entity2Info(Datasource datasource);

    List<DatasourceInfo> entities2Infos(List<Datasource> datasource);

}
