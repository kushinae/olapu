package org.kushinae.olapu.interfaces.service;

import org.springframework.data.repository.Repository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IRepositoryService<E, I> extends IService {

    Repository<E, I> getRepository();
}
