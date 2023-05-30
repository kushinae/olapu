package org.kushinae.olapu.api.pojo.api.template;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.kushinae.olapu.repository.enums.TemplateModel;
import org.kushinae.olapu.repository.enums.TemplateSource;
import org.kushinae.olapu.repository.enums.TemplateType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class CreatePayload {

    @NotNull(message = "模版所属不能为空")
    private TemplateSource source;

    @NotNull(message = "模版类型不能为空")
    private TemplateType type;

    private TemplateModel model;

    @NotNull(message = "模版不能为空")
    private String template;

    @NotBlank(message = "模版名称不能为空")
    private String name;

    private String description;

}
