package org.kushinae.olapu.interfaces.service;

import org.kushinae.olapu.repository.repository.IServiceRepository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IRepositoryService<E, I, R extends IServiceRepository<E, I>> extends IService {

    R getRepository();
}
