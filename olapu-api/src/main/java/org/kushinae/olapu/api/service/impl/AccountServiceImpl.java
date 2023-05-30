package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.pojo.api.account.LoginPayload;
import org.kushinae.olapu.api.service.AccountService;
import org.kushinae.olapu.api.vo.account.Login;
import org.kushinae.olapu.repository.repository.AccountRepository;
import org.springframework.stereotype.Service;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountRepository accountRepository;

    @Override
    public Login login(LoginPayload payload) {



        return null;
    }

    @Override
    public AccountRepository getRepository() {
        return accountRepository;
    }
}
