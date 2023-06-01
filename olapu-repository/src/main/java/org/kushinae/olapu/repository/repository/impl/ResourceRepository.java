package org.kushinae.olapu.repository.repository.impl;

import org.kushinae.olapu.repository.entities.Resource;
import org.kushinae.olapu.repository.enums.FileType;
import org.kushinae.olapu.repository.repository.IServiceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Repository
public interface ResourceRepository extends IServiceRepository<Resource, Long> {

    Resource searchById(Long id);

    Resource searchByParentIdAndNameAndType(Long parentId, String name, FileType type);

    List<Resource> findAllByParentId(Long parentId);
    List<Resource> findAllByParentIdAndName(Long parentId, String name);

}
