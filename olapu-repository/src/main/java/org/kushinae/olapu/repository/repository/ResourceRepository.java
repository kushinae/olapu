package org.kushinae.olapu.repository.repository;

import org.kushinae.olapu.repository.entities.Resource;
import org.kushinae.olapu.repository.enums.FileType;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Repository
public interface ResourceRepository extends ListPagingAndSortingRepository<Resource, Long> {

    Resource searchById(Long id);

    Resource searchByParentIdAndNameAndType(Long parentId, String name, FileType type);

}
