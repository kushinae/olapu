package org.kushinae.olapu.api.vo.account;

import lombok.Builder;
import lombok.Data;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Builder
public class Register {

    private String uid;

    private String nickname;

    private String avatar;

}
