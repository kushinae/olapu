package org.kushinae.olapu.api.vo.datasource;

import lombok.Data;
import org.kushinae.olapu.repository.enums.DatasourceType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class DatasourceInfo {

    private Long id;

    private String name;

    private DatasourceType type;

}
