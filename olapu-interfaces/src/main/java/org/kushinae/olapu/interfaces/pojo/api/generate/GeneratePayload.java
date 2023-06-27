package org.kushinae.olapu.interfaces.pojo.api.generate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kushinae.olapu.repository.enums.TemplateModel;
import org.kushinae.olapu.repository.enums.TemplateSource;
import org.kushinae.olapu.repository.enums.TemplateType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class GeneratePayload {

    private TemplateSource source;

    private TemplateType type;

    private TemplateModel model;

    @JsonProperty("datasource_id")
    private Long datasourceId;

    @JsonProperty("template_id")
    private Long templateId;

}
