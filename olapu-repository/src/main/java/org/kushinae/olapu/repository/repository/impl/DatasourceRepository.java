package org.kushinae.olapu.repository.repository.impl;

import org.kushinae.olapu.repository.entities.Datasource;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.kushinae.olapu.repository.repository.IServiceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Repository
public interface DatasourceRepository extends IServiceRepository<Datasource, Long> {

    Datasource searchByNameAndUidAndType(String name, String uid, DatasourceType type);

    Datasource searchByTypeAndTemplateIsTrue(DatasourceType type);

    Datasource searchByIdAndUid(Long id, String uid);

    Page<Datasource> findAllByNameLike(String name, Pageable pageable);

    Page<Datasource> findAll(Specification<Datasource> specification, Pageable pageable);

}
