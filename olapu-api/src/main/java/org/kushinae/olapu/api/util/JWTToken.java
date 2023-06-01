package org.kushinae.olapu.api.util;

import lombok.Builder;
import lombok.Data;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Builder
public class JWTToken {

    private String uid;

}
