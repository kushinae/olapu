package org.kushinae.olapu.api.vo.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.kushinae.olapu.api.authorization.AbstractAuthorization;
import org.kushinae.olapu.api.enums.TokenType;
import org.kushinae.olapu.repository.enums.FileType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class EditResource {

    private String name;

    private FileType type;

    @JsonProperty("parent_id")
    private Long parentId;

    private String content;

}
