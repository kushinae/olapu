package org.kushinae.olapu.interfaces.vo.datasource;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.kushinae.olapu.repository.enums.DatasourceType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Schema(name = "Configure", description = "数据源配置对象")
public class DatasourceInfo {

    @Parameter(description = "数据源id")
    private Long id;

    @Parameter(description = "数据源名称")
    private String name;

    @Parameter(description = "数据源类型")
    private DatasourceType type;

}
