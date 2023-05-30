package org.kushinae.olapu.api.pojo.api.generate;

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

}