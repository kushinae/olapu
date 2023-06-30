package org.kushinae.olapu.interfaces.vo.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.kushinae.olapu.core.enums.FileType;
import org.kushinae.olapu.core.enums.ResourceCategory;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Schema(name = "Edit Resource Payload", description = "编辑资源请求负载")
public class EditResource {

    @Parameter(description = "资源名称，这在同一个父文件夹中是唯一的")
    private String name;

    @Parameter(description = "资源类型 文件或者是文件夹 在资源分类为resource并且它是file类型才会有意义")
    private FileType type;

    @Parameter(description = "资源分类")
    private ResourceCategory category;

    @JsonProperty("parent_id")
    @Parameter(description = "父资源主键ID 父资源不应该不存在")
    private Long parentId;

    @Parameter(description = "文件内容 当资源分类为resource并且它是file类型时才会有意义")
    private String content;

}
