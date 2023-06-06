package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.enums.TokenType;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.api.pojo.account.AccountDetails;
import org.kushinae.olapu.api.pojo.api.account.LoginPayload;
import org.kushinae.olapu.api.service.AccountService;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.api.util.AccessTokenUtils;
import org.kushinae.olapu.api.vo.account.Login;
import org.kushinae.olapu.repository.entities.Account;
import org.kushinae.olapu.repository.repository.impl.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

        Account account = getAccount(payload.getUsername(), payload.getPassword());
        AbstractAssert.notNull(account, ErrorMessage.WRONG_USERNAME_OR_PASSWORD);

        String accessToken = AccessTokenUtils.createFromJWT(account.getUid(), account.getUid(), account.getUsername());

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
    public Account getAccountByUid(String uid) {
        return getRepository().searchByUid(uid);
    }

    @Override
    public AccountRepository getRepository() {
        return accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = getAccount(username);
        return AccountDetails
                .build()
                .enabled(account.getEnabled())
                .expired(account.getExpired())
                .locked(account.getLocked())
                .username(account.getUsername())
                .password(account.getPassword());
    }
}
