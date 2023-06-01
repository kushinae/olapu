package org.kushinae.olapu.repository.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IServiceRepository<E, I> extends CrudRepository<E, I>, ListPagingAndSortingRepository<E, I> {

}
