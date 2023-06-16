package org.kushinae.olapu.api.pojo.api.datasource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kushinae.olapu.repository.enums.DatasourceType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class CreatePayload {

    private String name;

    private DatasourceType type;

    private Boolean template = false;

}
