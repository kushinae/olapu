package org.kushinae.olapu.repository.repository.impl;

import org.kushinae.olapu.repository.entities.Account;
import org.kushinae.olapu.repository.repository.IServiceRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Repository
public interface AccountRepository extends IServiceRepository<Account, Long> {

    Account searchByUsernameAndPassword(String username, String password);

    Account searchByUsername(String username);

    Account searchByUid(String uid);

}
