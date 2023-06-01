package org.kushinae.olapu.api.service;

import org.springframework.data.repository.Repository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IRepositoryService<E, I> {

    Repository<E, I> getRepository();
}
