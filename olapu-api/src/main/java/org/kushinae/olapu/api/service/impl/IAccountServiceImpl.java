package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.convert.AccountConvert;
import org.kushinae.olapu.interfaces.enums.TokenType;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.interfaces.service.IAccountService;
import org.kushinae.olapu.core.util.AbstractAssert;
import org.kushinae.olapu.core.util.AccessTokenUtils;
import org.kushinae.olapu.core.util.UidUtils;
import org.kushinae.olapu.interfaces.pojo.api.account.LoginPayload;
import org.kushinae.olapu.interfaces.pojo.api.account.RegisterPayload;
import org.kushinae.olapu.interfaces.vo.account.Login;
import org.kushinae.olapu.interfaces.vo.account.Register;
import org.kushinae.olapu.repository.entities.Account;
import org.kushinae.olapu.repository.repository.impl.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class IAccountServiceImpl implements IAccountService {

    private static final Integer UID_LENGTH = 28;

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
    public Register register(RegisterPayload payload) {
        Account account = AccountConvert.INSTANCE.registerToDomain(payload);
        account.setUid(UidUtils.generate(UID_LENGTH));
        account.setExpired(false);
        account.setLocked(false);
        account.setEnabled(true);
        account.setCreateAt(new Date());
        account.setModifiedAt(new Date());
        account.setDeleted(false);

        Account save = getRepository().save(account);
        return Register.builder().uid(save.getUid()).nickname(save.getNickname()).avatar(save.getAvatar()).build();
    }
}
