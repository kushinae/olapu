package org.kushinae.olapu.api.pojo.api.datasource;

import lombok.Data;
import org.kushinae.olapu.repository.enums.DatasourceType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class CreatePayload {

    /**
     * 资源ID 该资源不能为 {@link org.kushinae.olapu.repository.enums.FileType#FILE}
     */
    private Long resourceId;

    private String name;

    private DatasourceType type;

}
