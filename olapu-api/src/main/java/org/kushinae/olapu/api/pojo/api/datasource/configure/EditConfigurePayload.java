package org.kushinae.olapu.api.pojo.api.datasource.configure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kushinae.olapu.api.vo.datasource.configure.Configure;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class EditConfigurePayload {

    @JsonProperty("datasource_id")
    private Long datasourceId;

    private List<Configure> configures;

}
