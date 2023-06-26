package org.kushinae.olapu.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.kushinae.olapu.api.pojo.api.account.LoginPayload;
import org.kushinae.olapu.api.pojo.api.account.RegisterPayload;
import org.kushinae.olapu.api.service.AccountService;
import org.kushinae.olapu.api.vo.account.Login;
import org.kushinae.olapu.api.vo.account.Register;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
@Tag(name = "账户连接控制器", description = "包含登录、注册、注销以及用于将某些帐户连接到系统的 API")
public class AccountLinkedController extends AbstractController {

    @Resource
    AccountService accountService;

    @PostMapping("/login")
    @Operation(summary = "登录olapu", description = "使用该接口登录，获取登录信息和认证信息")
    public Login login(@RequestBody LoginPayload payload) {
        return accountService.login(payload);
    }

    @PostMapping("/register")
    @Operation(summary = "在olapu注册一个帐户", description = "使用该api在olapu注册账号")
    public Register register(@RequestBody RegisterPayload payload) {
        return accountService.register(payload);
    }

}
