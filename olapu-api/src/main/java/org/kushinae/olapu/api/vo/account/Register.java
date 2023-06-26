package org.kushinae.olapu.api.vo.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Builder
@Schema(name = "Register VO", description = "注册响应")
public class Register {

    @Schema(description = "用户唯一uid")
    private String uid;

    @Schema(description = "用户显示昵称")
    private String nickname;

    @Schema(description = "用户头像地址")
    private String avatar;

}
