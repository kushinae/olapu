package org.kushinae.olapu.interfaces.service;

import org.kushinae.olapu.interfaces.pojo.lang.DatasourceConfigureMapping;
import org.kushinae.olapu.repository.entities.DatasourceConfigure;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.kushinae.olapu.repository.repository.impl.DatasourceConfigureRepository;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IDatasourceConfigureService extends IRepositoryService<DatasourceConfigure, Long, DatasourceConfigureRepository> {

    /**
     * 通过数据源ID获取数据源配置项
     *
     * @param datasourceId 数据源ID
     * @return 数据源配置项列表
     */
    List<DatasourceConfigure> configures(Long datasourceId);

    /**
     * 通过数据源类型加载模版
     *
     * @param type 数据源类型
     * @return 返回数据源类型的模版配置项列表
     */
    List<DatasourceConfigure> template(DatasourceType type);

    /**
     * 添加数据源配置
     *
     * @param datasourceId 数据源ID
     * @param uid 所有用户ID
     * @param configures   配置项列表
     * @return 数据源相关配置项
     */
    List<DatasourceConfigure> configure(Long datasourceId, String uid, List<DatasourceConfigure> configures);

    DatasourceConfigureMapping load2Mapping(List<DatasourceConfigure> datasourceConfigures);

    DatasourceConfigureMapping load2Mapping(Long datasourceId);
}
