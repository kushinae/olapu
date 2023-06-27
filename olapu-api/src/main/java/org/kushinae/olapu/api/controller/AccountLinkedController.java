package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.interfaces.service.IAccountService;
import org.kushinae.olapu.interfaces.controller.AbstractController;
import org.kushinae.olapu.interfaces.controller.account.IAccountLinkedController;
import org.kushinae.olapu.interfaces.pojo.api.account.LoginPayload;
import org.kushinae.olapu.interfaces.pojo.api.account.RegisterPayload;
import org.kushinae.olapu.interfaces.vo.account.Login;
import org.kushinae.olapu.interfaces.vo.account.Register;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
public class AccountLinkedController extends AbstractController implements IAccountLinkedController {

    @Resource
    private IAccountService accountService;

    @Override
    public Login login(LoginPayload payload) {
        return getService().login(payload);
    }

    @Override
    public Register register(RegisterPayload payload) {
        return getService().register(payload);
    }

    @Override
    public IAccountService getService() {
        return accountService;
    }
}
