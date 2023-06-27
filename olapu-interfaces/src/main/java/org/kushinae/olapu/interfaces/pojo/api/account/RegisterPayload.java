package org.kushinae.olapu.interfaces.pojo.api.account;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Schema(name = "Register Payload", description = "注册用户请求负载")
public class RegisterPayload {

    /**
     * 登陆用户名
     */
    @NotBlank(message = "username cannot be empty")
    @Schema(description = "登陆用户名")
    private String username;

    /**
     * 登陆密码 md5之后
     */
    @NotBlank(message = "password cannot be empty")
    @Schema(description = "登陆密码，原文md5之后获取32位小")
    private String password;

    /**
     * 展示名称
     */
    @NotBlank(message = "nickname cannot be empty")
    @Schema(description = "用户显示昵称")
    private String nickname;

    @Schema(description = "用户头像地址")
    private String avatar;

}
