package org.kushinae.olapu.repository.repository;

import org.kushinae.olapu.repository.entities.Account;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Repository
public interface AccountRepository extends ListPagingAndSortingRepository<Account, Long> {
}
