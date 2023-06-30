package org.kushinae.olapu.interfaces.pojo.api.template;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.kushinae.olapu.core.enums.TemplateModel;
import org.kushinae.olapu.core.enums.TemplateSource;
import org.kushinae.olapu.core.enums.TemplateType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Schema(name = "Create Template Payload", description = "创建模版请求负载")
public class CreatePayload {

    @NotNull(message = "模版所属不能为空")
    @Parameter(description = "模版所属")
    private TemplateSource source;

    @NotNull(message = "模版类型不能为空")
    @Parameter(description = "模版类型")
    private TemplateType type;

    @Parameter(description = "模版模型")
    private TemplateModel model;

    @NotNull(message = "模版不能为空")
    @Parameter(description = "模版内容")
    private String template;

    @Parameter(hidden = true)
    private String uid;

    @NotBlank(message = "模版名称不能为空")
    @Parameter(description = "模版名称 它应该是唯一不能重复的")
    private String name;

    @Parameter(description = "模版描述")
    private String description;
}
