package org.kushinae.olapu.repository.repository;

import org.springframework.data.repository.Repository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IRepositoryService<E, I> {

    Repository<E, I> getRepository();


}
