package org.kushinae.olapu.interfaces.pojo.api.datasource;

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
