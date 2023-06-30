package org.kushinae.olapu.interfaces.pojo.api.datasource;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import org.kushinae.olapu.core.enums.DatasourceType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class CreatePayload {

    @Parameter(description = "数据源名称 这是唯一的")
    private String name;

    @Parameter(description = "数据源类型")
    private DatasourceType type;

    @Parameter(description = "该数据源是否为模版数据源")
    private Boolean template = false;

}
