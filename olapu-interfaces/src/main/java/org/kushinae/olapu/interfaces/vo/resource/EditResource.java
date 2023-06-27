package org.kushinae.olapu.interfaces.vo.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kushinae.olapu.repository.enums.FileType;
import org.kushinae.olapu.repository.enums.ResourceCategory;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class EditResource {

    private String name;

    private FileType type;

    private ResourceCategory category;

    @JsonProperty("parent_id")
    private Long parentId;

    private String content;

}
