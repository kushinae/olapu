package org.kushinae.olapu.api.vo.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.kushinae.olapu.api.enums.TokenType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Builder
public class Login {

    private String uid;

    private String nickname;

    private String avatar;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private TokenType tokenType;

}
