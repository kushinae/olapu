package org.kushinae.olapu.interfaces.pojo.api.datasource.configure;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import org.kushinae.olapu.interfaces.vo.datasource.configure.Configure;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class EditConfigurePayload {

    @JsonProperty("datasource_id")
    @Parameter(description = "数据源ID", required = true)
    private Long datasourceId;

    @Parameter(description = "数据源配置列表", required = true)
    private List<Configure> configures;

}
