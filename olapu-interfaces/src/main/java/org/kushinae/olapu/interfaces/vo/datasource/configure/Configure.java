package org.kushinae.olapu.interfaces.vo.datasource.configure;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class Configure {

    @Parameter(description = "配置ID")
    public Long id;

    @Parameter(description = "配置key")
    public String key;

    @Parameter(description = "配置值")
    private String value;

}
