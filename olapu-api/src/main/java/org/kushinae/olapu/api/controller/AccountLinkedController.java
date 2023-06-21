package org.kushinae.olapu.api.controller;

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
public class AccountLinkedController extends AbstractController {

    @Resource
    AccountService accountService;

    @PostMapping("/login")
    public Login login(@RequestBody LoginPayload payload) {
        return accountService.login(payload);
    }

    @PostMapping("/register")
    public Register register(@RequestBody RegisterPayload payload) {
        return accountService.register(payload);
    }

}
