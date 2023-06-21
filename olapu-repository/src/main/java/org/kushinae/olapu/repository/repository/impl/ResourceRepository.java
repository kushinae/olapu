package org.kushinae.olapu.repository.repository.impl;

import org.kushinae.olapu.repository.entities.Resource;
import org.kushinae.olapu.repository.enums.FileType;
import org.kushinae.olapu.repository.enums.ResourceCategory;
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

    List<Resource> findAllByParentIdAndUid(Long parentId, String uid);

    List<Resource> findAllByParentIdAndNameLikeAndUidAndCategory(Long parentId, String name, String uid, ResourceCategory category);

}
