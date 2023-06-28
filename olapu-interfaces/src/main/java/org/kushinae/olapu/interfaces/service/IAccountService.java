package org.kushinae.olapu.interfaces.service;

import org.kushinae.olapu.interfaces.pojo.api.account.LoginPayload;
import org.kushinae.olapu.interfaces.pojo.api.account.RegisterPayload;
import org.kushinae.olapu.interfaces.vo.account.Login;
import org.kushinae.olapu.interfaces.vo.account.Register;
import org.kushinae.olapu.repository.entities.Account;
import org.kushinae.olapu.repository.repository.impl.AccountRepository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IAccountService extends IRepositoryService<Account, Long, AccountRepository> {

    Login login(LoginPayload payload);

    Account getAccount(String username, String password);

    Account getAccount(String username);

    Account getAccountByUid(String uid);

    @Override
    AccountRepository getRepository();

    Register register(RegisterPayload payload);
}
