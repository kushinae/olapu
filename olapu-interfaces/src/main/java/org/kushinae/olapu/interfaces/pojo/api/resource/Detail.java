package org.kushinae.olapu.interfaces.pojo.api.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kushinae.olapu.core.enums.FileType;
import org.kushinae.olapu.core.enums.ResourceCategory;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class Detail {

    private Long id;

    private FileType type;

    private ResourceCategory category;

    private String name;

    @JsonProperty("parent_id")
    private Long parentId;

    private String content;

    private String uid;

}
