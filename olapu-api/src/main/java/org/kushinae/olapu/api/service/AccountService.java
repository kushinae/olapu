package org.kushinae.olapu.api.service;

import org.kushinae.olapu.api.pojo.api.account.LoginPayload;
import org.kushinae.olapu.api.pojo.api.account.RegisterPayload;
import org.kushinae.olapu.api.vo.account.Login;
import org.kushinae.olapu.api.vo.account.Register;
import org.kushinae.olapu.repository.entities.Account;
import org.springframework.data.repository.Repository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface AccountService extends IRepositoryService<Account, Long> {

    Login login(LoginPayload payload);

    Account getAccount(String username, String password);

    Account getAccount(String username);

    Account getAccountByUid(String uid);

    @Override
    Repository<Account, Long> getRepository();

    Register register(RegisterPayload payload);
}
