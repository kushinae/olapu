package org.kushinae.olapu.api.pojo.api.account;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class RegisterPayload {

    /**
     * 登陆用户名
     */
    @NotBlank(message = "username cannot be empty")
    private String username;

    /**
     * 登陆密码 md5之后
     */
    @NotBlank(message = "password cannot be empty")
    private String password;

    /**
     * 展示名称
     */
    @NotBlank(message = "nickname cannot be empty")
    private String nickname;

    private String avatar;

}
