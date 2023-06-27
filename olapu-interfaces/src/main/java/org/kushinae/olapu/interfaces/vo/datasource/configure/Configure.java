package org.kushinae.olapu.interfaces.vo.datasource.configure;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Schema(name = "Configure VO", description = "数据源配置对象")
public class Configure {

    @Parameter(description = "配置ID，如果在修改时不能为空")
    public Long id;

    @Parameter(description = "配置key")
    public String key;

    @Parameter(description = "配置值")
    private String value;

}
