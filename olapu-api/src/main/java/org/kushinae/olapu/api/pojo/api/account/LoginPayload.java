package org.kushinae.olapu.api.pojo.api.account;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Schema(name = "Login Payload", description = "登陆请求负载")
public class LoginPayload {

    /**
     * 登陆用户名
     */
    @NotBlank(message = "username cannot be empty")
    @Schema(description = "用户名")
    private String username;

    /**
     * 登陆密码 md5之后
     */
    @NotBlank(message = "password cannot be empty")
    @Schema(description = "登陆密码需要使用md5加密32位小提交")
    private String password;

}
