package org.kushinae.olapu.interfaces.controller.account;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kushinae.olapu.interfaces.controller.IController;
import org.kushinae.olapu.interfaces.pojo.api.account.LoginPayload;
import org.kushinae.olapu.interfaces.pojo.api.account.RegisterPayload;
import org.kushinae.olapu.interfaces.vo.account.Login;
import org.kushinae.olapu.interfaces.vo.account.Register;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Tag(name = "账户连接控制器", description = "包含登录、注册、注销以及用于将某些帐户连接到系统的 API")
public interface IAccountLinkedController extends IController {

    @PostMapping("/login")
    @Operation(summary = "登录olapu", description = "使用该接口登录，获取登录信息和认证信息")
    Login login(@RequestBody LoginPayload payload);

    @PostMapping("/register")
    @Operation(summary = "在olapu注册一个帐户", description = "使用该api在olapu注册账号")
    Register register(@RequestBody RegisterPayload payload);

}
