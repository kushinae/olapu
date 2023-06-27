package org.kushinae.olapu.interfaces.vo.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.kushinae.olapu.interfaces.enums.TokenType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Builder
@Schema(name = "Login VO", description = "登陆响应对象")
public class Login {

    @Schema(description = "用户唯一uid")
    private String uid;

    @Schema(description = "用户显示昵称")
    private String nickname;

    @Schema(description = "用户头像地址")
    private String avatar;

    @JsonProperty("access_token")
    @Schema(description = "用户鉴权token")
    private String accessToken;

    @JsonProperty("token_type")
    @Schema(description = "用户token类型")
    private TokenType tokenType;

}
