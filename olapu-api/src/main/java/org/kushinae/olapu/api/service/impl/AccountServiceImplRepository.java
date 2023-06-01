package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.enums.TokenType;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.api.pojo.api.account.LoginPayload;
import org.kushinae.olapu.api.service.AccountServiceRepository;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.api.util.AccessTokenUtils;
import org.kushinae.olapu.api.vo.account.Login;
import org.kushinae.olapu.repository.entities.Account;
import org.kushinae.olapu.repository.repository.impl.AccountRepository;
import org.springframework.stereotype.Service;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class AccountServiceImplRepository implements AccountServiceRepository {

    @Resource
    AccountRepository accountRepository;

    @Override
    public Login login(LoginPayload payload) {

        Account account = getAccount(payload.getUsername(), payload.getPassword());
        AbstractAssert.notNull(account, ErrorMessage.WRONG_USERNAME_OR_PASSWORD);

        String accessToken = AccessTokenUtils.createFromJWT(account.getUid(), account.getUid());

        return Login.builder()
                .uid(account.getUid())
                .nickname(account.getNickname())
                .avatar(account.getAvatar())
                .accessToken(accessToken)
                .tokenType(TokenType.BEARER)
                .build();
    }

    @Override
    public Account getAccount(String username, String password) {
        AccountRepository repository = getRepository();
        return repository.searchByUsernameAndPassword(username, password);
    }

    @Override
    public Account getAccount(String username) {
        AccountRepository repository = getRepository();
        return repository.searchByUsername(username);
    }

    @Override
    public AccountRepository getRepository() {
        return accountRepository;
    }
}
