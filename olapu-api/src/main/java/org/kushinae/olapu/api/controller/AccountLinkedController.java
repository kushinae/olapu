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
@Tag(name = "Account connection controller", description = "Contains login, registration, logout and APIs for connecting some accounts to the system")
public class AccountLinkedController extends AbstractController {

    @Resource
    AccountService accountService;

    @PostMapping("/login")
    @Operation(summary = "Login to Olapu", description = "Use this interface to log in to obtain login information and authentication information")
    public Login login(@RequestBody LoginPayload payload) {
        return accountService.login(payload);
    }

    @PostMapping("/register")
    @Operation(summary = "Register an account in olapu", description = "Use this api to register an account in olapu")
    public Register register(@RequestBody RegisterPayload payload) {
        return accountService.register(payload);
    }

}
