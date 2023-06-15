package org.kushinae.olapu.api.convert;

import org.kushinae.olapu.api.vo.datasource.configure.Configure;
import org.kushinae.olapu.repository.entities.DatasourceConfigure;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Mapper
public interface DatasourceConfigureConvert {

    DatasourceConfigureConvert INSTANCE = Mappers.getMapper(DatasourceConfigureConvert.class);

    List<Configure> entities2Configures(List<DatasourceConfigure> datasourceConfigures);

    Configure entity2Configure(DatasourceConfigure datasourceConfigure);

    List<DatasourceConfigure> configures2Entities(List<Configure> datasourceConfigures);

    DatasourceConfigure configure2entity(Configure configure);

}
