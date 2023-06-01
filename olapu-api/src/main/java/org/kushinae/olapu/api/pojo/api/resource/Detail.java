package org.kushinae.olapu.api.pojo.api.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kushinae.olapu.repository.enums.FileType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class Detail {

    private Long id;

    private FileType type;

    private String name;

    @JsonProperty("parent_id")
    private Long parentId;

    private String content;

    private String uid;

}
